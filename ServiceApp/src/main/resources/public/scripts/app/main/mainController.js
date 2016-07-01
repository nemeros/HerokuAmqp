(function(){
	'use strict';
	
	angular.module('serviceApp')
	    .controller('mainController', mainController);
	
	mainController.$inject = ['$log'];
	
	function mainController($log){
		var vm = this;
		
		$log.debug("Init Main");
	};
})();