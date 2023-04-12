const app = angular.module("shopping-cart-app",[]);
app.controller("shopping-cart-ctrl", function( $scope, $http){
    alert("AngularJs")
    $scope.cart = {
        items: [],
        add(id){
          var item = this.items.find(item => item.id == id);
          if(item){
            item.qty++;
            this.saveToLocalStorage();
          }
          else{
            $http.get(`/api/rest/product/${id}`).then(resp => {
                resp.data.qty = 1;
                this.items.push(resp.data);
                this.saveToLocalStorage();  
            })
          }
        },
        remove(id){},
        clear(){},
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
    }
})
