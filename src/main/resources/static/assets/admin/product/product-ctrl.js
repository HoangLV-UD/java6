app.controller("product-ctrl", function($scope, $http){
	$scope.initialize = function(){
		$http.get("/api/rest/category").then(resp => {
			$scope.categories = resp.data;
		})

		$http.get("/api/rest/product").then(resp => {
			$scope.items = resp.data;
			$scope.items.forEach(item => {
				item.createDate = new Date(item.createDate)
			})
		});
		$scope.reset();
	}
	
	$scope.reset = function(){
		$scope.form = {
			createDate: new Date(),
			available: true,
			image: "cloud-upload.jpg"
		}
	}

	$scope.edit = function(item){
		$scope.form = angular.copy(item);
		$(".nav-tabs a:eq(0)").tab("show");
	}

	$scope.create = function(){
		var item = angular.copy($scope.form);
		console.log('form',$scope)
		$http.post(`/api/rest/product`, item).then(resp => {
			resp.data.createDate = new Date(resp.data.createDate)
			$scope.items.push(resp.data);
			$scope.reset();
			console.log('form2',$scope)
			alert("Thêm mới sản phẩm thành công!");
		}).catch(error => {
			alert("Thêm mới sản phẩm thất bại!");
			console.log("Error", error);
		});
	}

	$scope.update = function(){
		var item = angular.copy($scope.form);
		$http.put(`/api/rest/product/${item.id}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;
			alert("Cập nhật sản phẩm thành công!");
		})
		.catch(error => {
			alert("Cập nhật sản phẩm thất bại!");
			console.log("Error", error);
		});
	}

	$scope.delete = function(item){
		if(confirm("Bạn muốn xóa sản phẩm này?")){
			$http.delete(`/api/rest/product/${item.id}`).then(resp => {
				var index = $scope.items.findIndex(p => p.id == item.id);
				$scope.items.splice(index, 1);
				$scope.reset();
				alert("Xóa sản phẩm thành công!");
			}).catch(error => {
				alert("Xóa sản phẩm thất bại!");
				console.log("Error", error);
			})
		}
	}
	
	$scope.imageChanged = function(files){
		var data = new FormData();
		data.append('file', files[0]);
		$http.post('/api/rest/upload/images', data, {
			transformRequest: angular.identity,
			headers: {'Content-Type': undefined}
        }).then(resp => {
			$scope.form.image = resp.data.name;
		}).catch(error => {
			alert("Upload hình ảnh thất bại");
			console.log("Error", error);
		})
	}

	$scope.initialize();

	$scope.pager = {
		page: 0,
		size: 10,
		get items(){
			if(this.page < 0){
				this.last();
			}
			if(this.page >= this.count){
				this.first();
			}
			var start = this.page*this.size;
			return $scope.items.slice(start, start + this.size)
		},
		get count(){
			return Math.ceil(1.0 * $scope.items.length / this.size);
		},
		first(){
			this.page = 0;
		},
		last(){
			this.page = this.count - 1;
		},
		next(){
			this.page++;
		},
		prev(){
			this.page--;
		}
	}
});