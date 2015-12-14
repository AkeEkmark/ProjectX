angular.module('projectx.result', [])
.controller('resultcontroller', [], function($scope)
		{$scope.refurbishment={}})
.directive('result', function(){
	return {
		restrict: 'E',
		replace: 'true',
		templateUrl: 'templates/result.html'
	};
});