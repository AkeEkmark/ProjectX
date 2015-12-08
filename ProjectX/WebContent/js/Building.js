angular.module("directives", [])
.directive('Building', function(){
	return {
		restrict: 'E',
		replace: 'true',
		templateUrl: 'templates/Building.html'
	};
});