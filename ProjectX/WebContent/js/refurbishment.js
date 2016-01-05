angular.module('projectx.refurbishment', [])
.directive('refurbishment', function(){
	return {
		restrict: 'E',
		replace: 'true',
		templateUrl: 'templates/refurbishment.html',
		controller: function($scope, $http) {
			$scope.getData=function(){
				$http({
					method: 'GET',
					url:'/ProjectX/api/Refurbishment'
					
				})
				.success(function(data){
					$scope.data=data;
				})
				.error(function(){
					$scope.data={};
				});
			};
			$scope.refurbishment={}
		},
		link:function(scope, element, attrs){
			scope.getData();
		}
	};
});