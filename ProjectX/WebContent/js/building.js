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
			$scope.building={}
		},
		link:function(scope, element, attrs){
			scope.getData();
		}
	};
});