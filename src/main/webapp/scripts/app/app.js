(function(){
	'use strict';
	
	angular.module('serviceApp', ['ngResource', 'ui.router', 'ui.bootstrap'])

		//route config
		.config(function($stateProvider, $urlRouterProvider){
			
			$urlRouterProvider.otherwise('/');
			
			$stateProvider.state('abstractHome', {
	            'abstract': true,
	            views: {
	                'navbar@': {
	                    templateUrl: 'scripts/components/navbar/navbar.html',
	                    controller: 'NavbarController as navBarVm'
	                }
	            }
	        });
		});
})();



