angular.module('projectx.building', [])
.controller('buildingcontroller', ['$scope', function($scope, $http) {
	
	$scope.getData=function(){
		$http({
			method: 'GET',
			url:'/api/Building'
			
		})
		.success(function(data){
			$scope.data=data;
		})
		.error(function(){
			$scope.data={};
		});
	};
	$scope.building={}
	
}])
.directive('building', function(){
	return {
		restrict: 'E',
		replace: 'true',
		
		templateUrl: 'templates/building.html',
		link:function(scope, element, attrs){
			scope.getData();
		}
	};
});