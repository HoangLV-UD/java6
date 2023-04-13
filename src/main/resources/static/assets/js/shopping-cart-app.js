const app = angular.module("shopping-cart-app",[]);
app.controller("shopping-cart-ctrl", function( $scope, $http){
    $scope.cart = {
        items: [],
        add(id){
          var item = this.items.find(item => item.id == id);
          if(item){
            item.qty++;
            this.saveToLocalStorage();
            alert("Success")
          }
          else{
            $http.get(`/api/rest/product/${id}`).then(resp => {
                resp.data.qty = 1;
                this.items.push(resp.data);
                this.saveToLocalStorage(); 
                alert("Success") 
            })
          }
        },
        remove(id){
          var index = this.items.findIndex(item => item.id == id); //tim sp theo id
          this.items.splice(index,1); //splice dùng để thêm hoặc loại bỏ phần tử xong mảng
          this.saveToLocalStorage();
        },
        clear(){
            this.items = []; //set mảng sp thành mảng rỗng 
            this.saveToLocalStorage(); // lưu
        }, 
        atm_of(item){},
        get count(){
            return this.items
            .map(item => item.qty)
            .reduce((total,qty) => total += qty, 0)
        },
        get amount(){
            return this.items
            .map(item => item.qty * item.price)
            .reduce((total,qty) => total += qty, 0)
        },
        saveToLocalStorage(){
            var json = JSON.stringify(angular.copy(this.items));
            localStorage.setItem("cart",json);
            
        },
        loadFromLocalStorage(){
          var json = localStorage.getItem("cart");
          this.items = json ? JSON.parse(json) : [];
        }
    }
    $scope.cart.loadFromLocalStorage();
})
