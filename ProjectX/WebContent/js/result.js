angular.module('projectx.result', [])
.directive('result', function(){
	return {
		restrict: 'E',
		replace: 'true',
		templateUrl: 'templates/result.html',
		controller: function($scope, $http) {
			
		},
		link:function(scope, element, attrs){
			
		}
	};
});