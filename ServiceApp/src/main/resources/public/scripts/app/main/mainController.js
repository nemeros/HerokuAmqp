(function(){
	'use strict';
	
	angular.module('serviceApp')
	    .controller('mainController', mainController);
	
	mainController.$inject = ['$log', 'helloService'];
	
	function mainController($log, helloService){
		var vm = this;
		
		vm.name = null;
		vm.valeur = null;
		vm.listMsg = null;
		
		vm.submit = submit;
		vm.refreshMsg = refreshMsg;
		
		
		function refreshMsg(){			
			helloService.getMsg().then(
					function successCallBack(response){
						vm.listMsg = response.data;
					},
					function errorCallBack(response){
						$log.error(angular.toJson(response));
					});
		}
			
		
		function submit(){
			var message = new Object();
			message.name = vm.name;
			message.valeur = vm.valeur;
			
			helloService.putMsg(message);
		}
	};
})();