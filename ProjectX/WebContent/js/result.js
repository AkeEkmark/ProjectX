angular.module('projectx.result', [])
.directive('result', function(){
	return {
		restrict: 'E',
		replace: 'true',
		templateUrl: 'templates/result.html',
		controller: function($scope, $http) {
			$scope.walldata = {};
			$scope.roofdata = {};
			$scope.getResult=function(){
				method: 'GET',
				$http({
					url:'/ProjectX/api/Result',
					params: {
						tier: $scope.refurbishment.roofceilingjoist,
						wall: $scope.refurbishment.outerwalls
					} 
					
				})
				.success(function(data){
					$scope.walldata = data.walls;
					$scope.roofdata = data.tieroflogs;
				})
				.error(function(){
					$scope.result={};
				});
			};
		},
		link:function(scope, element, attrs){
			
		}
	};
});