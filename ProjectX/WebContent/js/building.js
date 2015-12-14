angular.module('projectx.building', [])
.controller('buildingcontroller', [], function($scope)
		{$scope.building={}})
.directive('building', function(){
	return {
		restrict: 'E',
		replace: 'true',
		templateUrl: 'templates/building.html'
	};
});