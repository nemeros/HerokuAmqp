(function(){
	'use strict';
	
	angular.module('serviceApp')
	    .controller('mainController', mainController);
	
	mainController.$inject = ['$log', 'helloService'];
	
	function mainController($log, helloService){
		var vm = this;
		
		vm.name = null;
		vm.valeur = null;
		vm.submit = submit;
		
		
		$log.debug("Init Main");
		
		function submit(){
			var message = new Object();
			message.name = vm.name;
			message.valeur = vm.valeur;
			
			helloService.putMsg(message);
		}
	};
})();