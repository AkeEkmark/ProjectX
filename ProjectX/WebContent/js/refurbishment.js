angular.module('projectx.refurbishment', [])
.controller('refurbishmentcontroller', [], function($scope)	{
	
	$scope.refurbishment={}
	
})
.directive('refurbishment', function(){
	return {
		restrict: 'E',
		replace: 'true',
		templateUrl: 'templates/refurbishment.html'
	};
});