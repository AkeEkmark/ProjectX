angular.module('projectx.directives', [])
.controller('buildingcontroller', [], function($scope)
		{$scope.building={}})
.directive('building', function(){
	return {
		restrict: 'E',
		replace: 'true',
		templateUrl: 'templates/Building.html'
	};
});