(function(){
	'use strict';
	
	angular.module('serviceApp')
	    .controller('NavbarController', navBarController);
	
	
	navBarController.$inject = ['$log'];
	
	
	function navBarController($log) {
		var vm = this;
		
		vm.initNav = initNav;
	
		
		/////////////////
		
		function initNav(){
			$log.debug('init Nav');   
		};
	}
	   
})();