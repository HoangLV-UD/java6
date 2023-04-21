app.controller("category-ctrl", function ($scope, $http) {
    $scope.initialize = function () {
        $http.get("/api/rest/category").then(resp => {
            $scope.categories = resp.data;
            console.log(22222,resp.data);
        })
    }
    $scope.edit = function(category){
		$scope.form = angular.copy(category);
		$(".nav-tabs a:eq(0)").tab("show");
	}
    $scope.createCategory = function(){
		var category = angular.copy($scope.form);
        console.log('form',$scope.form)
		if (category && Object.keys(category).length > 0) { // kiểm tra xem item có giá trị hay không
            $http.post(`/api/rest/category`, category).then(resp => {
                console.log(333,category);
                $scope.categories.push(resp.data);
                $scope.reset();
                alert("Thêm mới danh mục thành công!");
            }).catch(error => {
                alert("Lỗi thêm mới danh mục!");
                console.log("Error", error);
            });
        } else {
            alert("Vui lòng điền đầy đủ thông tin!"); // thông báo nếu item rỗng
        }
	}

    $scope.updateCategory = function(){
		var item = angular.copy($scope.form);
		$http.put(`/api/rest/category/${item.id}`, item).then(resp => {
			var index = $scope.items.findIndex(p => p.id == item.id);
			$scope.items[index] = item;
			alert("Cập nhật danh mục thành công!");
		})
		.catch(error => {
			alert("Lỗi cập nhật  danh mục!");
			console.log("Error", error);
		});
	}
    $scope.initialize();
});