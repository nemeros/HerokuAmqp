(function(){
	'use strict'
	
	angular.module('serviceApp')
		.factory('helloService', helloService);
	
	helloService.$inject = ['$http'];
	
	function helloService ($http){
		var service = {
				putMsg: putMsg
		}
		
		return service;
		
		////////////////////////////////
		function putMsg(requestData){			
			return $http.put("/api/hello", requestData);
		}
	}	
})();