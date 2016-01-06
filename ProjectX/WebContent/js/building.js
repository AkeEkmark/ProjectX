angular.module('projectx.building', [])
.directive('building', function(){
	return {
		restrict: 'E',
		replace: 'true',
		templateUrl: 'templates/building.html',
		controller: function($scope, $http) {
			$scope.getData=function(){
				$http({
					method: 'GET',
					url:'/ProjectX/api/Building'
					
				})
				.success(function(data){
					$scope.data=data;
				})
				.error(function(){
					$scope.data={};
				});
			};
			$scope.building={};
			$scope.building.heatedarea = 100;
			$scope.building.levels = 1;
			$scope.circum = function() { return 2*(11.5 + ($scope.building.heatedarea / $scope.building.levels) / 11.5) + 2 };
			
			
		},
		link:function(scope, element, attrs){
			scope.getData();
		}
	};
});