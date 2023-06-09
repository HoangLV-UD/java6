app = angular.module("admin-app", ["ngRoute"]);

app.run(function($http, $rootScope){
    $http.get(`/api/rest/authorities`).then(resp => {
    	if(resp.data){
    		$auth = $rootScope.$auth = resp.data;
        	$http.defaults.headers.common["Authorization"] = $auth.token;
    	}
    });
})

app.config(function ($routeProvider) {
  $routeProvider
    .when("/product", {
      templateUrl: "/assets/admin/product/index.html",
      controller: "product-ctrl"
    })
    .when("/authorize", {
      templateUrl: "/assets/admin/authority/index.html",
      controller: "authority-ctrl"
    })
    .when("/category", {
          templateUrl: "/assets/admin/category/index.html",
          controller: "category-ctrl"
        })
    .when("/unauthorized", {
      templateUrl: "/assets/admin/authority/unauthorized.html",
      controller: "authority-ctrl"
    })
    .otherwise({
      template: "<h1 class='text-center'>FPT Polytechnic</h1>"
    });
});