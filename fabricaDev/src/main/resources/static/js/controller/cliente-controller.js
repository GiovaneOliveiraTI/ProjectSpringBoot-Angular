// Criação do controller

appCliente.controller("clienteController", function($scope, $http) {


	$scope.clientes = [];
	$scope.cliente = {};

	carregarClientes = function() {
		$http({method : 'GET',url : 'http://localhost:8080/clientes'}) 
			.then(function(response) {
			$scope.clientes = response.data;

		 

		}, function(response) {
			console.log(response.data);
			console.log(response.status);

		});

	};

	$scope.salvarClientes = function() {
		$http({method : 'POST',url:'http://localhost:8080/clientes',data: $scope.cliente})
			.then(function(response) {
			//$scope.clientes.push(response.data);
              carregarClientes();
              $scope.cancelarAlteracao();
			

		}, function(response) {
			console.log(response.data);
			console.log(response.status);

		});

	}
	
	$scope.excluirClientes = function(cliente){
		$http({method: 'DELETE',url:'http://localhost:8080/clientes'+cliente.id})
		.then(function(response) {
        
	    pos = $scope.clientes.indexOf(cliente); 
	    $scope.clientes.splice(pos , 1);
	
		}, function(response) {
		console.log(response.data);
		console.log(response.status);

	});

	
	}
	
	$scope.alterarClientes = function(cli){
		$scope.cliente= angular.copy(cli);
		
	}
	
	$scope.cancelarAlteracao = function(){
		$scope.cliente={};
		
	}

	carregarClientes();

});