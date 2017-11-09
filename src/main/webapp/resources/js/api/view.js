var myApp = angular.module('main', []);



myApp.controller('mainCtrl', ['$scope','$http' ,function ($scope,$http) {

}]);

myApp.controller('ropsCtrl', ['$scope','$http', function ($scope,$http) {
	
	
	
	$scope.pageTotal = 10;
	$scope.pageNum = 1;
	$scope.prev = 0;
	$scope.next = 0;
	$scope.changeMode = 1;
	
	
	
	
	getG1();
	getG2();
	getList();
	
	
	$scope.listPrev = function(){
		$scope.pageNum = $scope.prev;
		
		getList();
	}
	$scope.listNext = function(){
		$scope.pageNum = $scope.next;
		getList();
	}
	$scope.listGo = function(x){
		if(x.toString().indexOf('(') == -1){
			$scope.pageNum = x;
			getList();
		}
	}
	
	$scope.getEmissionList = function(){
		$scope.pageNum = 1;
		getList();
	}
	
	
	
	$scope.addG1 = function(changeMode){
		if($scope.g1_name == null){
			alert("이름을 입력해주세요");
			return;
		}
		$scope.changeMode = changeMode;
		
		go();
		
		
		function go(){
		
			var formData = {
				"g1_name" : $scope.g1_name,
			};
			$http({
				method: 'post',
				url: '/admin/count/addG1.do',
				data: formData,
				headers: {'Content-Type':'application/json; charset=utf-8'}
			}).success(function(data,status,headers,config){
				if(data){
					getG1();
					
				}else{	
				}
			}).error(function(data,status,headers,config){
				console.log(status);
			});
		
		}
		
	};
	
	$scope.addG2 = function(changeMode){
		if($scope.g2_name == null){
			alert("이름을 입력해주세요");
			return;
		}
		$scope.changeMode = changeMode;
		
		go();
		
		
		function go(){
		
			var formData = {
				"g1_idx" : $scope.g1_idx,
				"g2_name" : $scope.g2_name,
			};
			$http({
				method: 'post',
				url: '/admin/count/addG2.do',
				data: formData,
				headers: {'Content-Type':'application/json; charset=utf-8'}
			}).success(function(data,status,headers,config){
				if(data){
					getG2();
				}else{	
				}
			}).error(function(data,status,headers,config){
				console.log(status);
			});
		
		}
		
	};
	
	$scope.addList = function(changeMode){
		if($scope.list_name == null){
			alert("이름을 입력해주세요");
			return;
		}
		$scope.changeMode = changeMode;
		
		go();
		
		
		function go(){
		
			var formData = {
				"g1_idx" : $scope.g1_idx,
				"g2_idx" : $scope.g2_idx,
				"list_name" : $scope.list_name,
			};
			$http({
				method: 'post',
				url: '/admin/count/addList.do',
				data: formData,
				headers: {'Content-Type':'application/json; charset=utf-8'}
			}).success(function(data,status,headers,config){
				if(data){
					$scope.pageNum = 1;
					getList();
					
				}else{	
				}
			}).error(function(data,status,headers,config){
				console.log(status);
			});
		
		}
		
	};
	
	function getG1(){
		$scope.g1_idx = '1';
		$scope.g2_idx = '1';
		$scope.did_idx = '1';
		var formData = {
		};
		$http({
			method: 'post',
			data: formData,
			url: '/admin/count/getG1.do',
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.g1 = data.beanlist;
				
				getG2();
			}else{
				
			}
		}).error(function(data,status,headers,config){
			console.log(status);
		});
		
		
	}
	$scope.getG2 = function(){
		getG2();
	}
	
	function getG2(){
		$scope.g2_idx = '1';
		$scope.did_idx = '1';
		var formData = {
			"g1_idx" : $scope.g1_idx,
		};
		$http({
			method: 'post',
			data: formData,
			url: '/admin/count/getG2.do',
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.g2 = data.beanlist;
				$scope.did_idx = '0';
				getDid();
			}else{
				
			}
			
		}).error(function(data,status,headers,config){
			console.log(status);
		});
	}
	
	
	$scope.getDid = function(){
		getDid();
	}
	
	function getDid(){
		$scope.did_idx = '1';
		var formData = {
			"g1_idx" : $scope.g1_idx,
			"g2_idx" : $scope.g2_idx,
		};
		$http({
			method: 'post',
			data: formData,
			url: '/admin/count/getDid.do',
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.did = data.beanlist;
				getList();
			}else{
				
			}
			
		}).error(function(data,status,headers,config){
			console.log(status);
		});
	}
	
	$scope.getList = function(){
		getList();
	};
	
	
	function getList(){
		var formData = {
			"pageNum" : ($scope.pageNum-1)*$scope.pageTotal,
			"total" : $scope.pageTotal,
			"g1_idx" : $scope.g1_idx,
			"g2_idx" : $scope.g2_idx,
			"did_idx" : $scope.did_idx,
		};
		$http({
			method: 'post',
			data: formData,
			url: '/admin/count/getList.do',
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.list = data.beanlist;
				$scope.listTotal = data.listTotal;
				var total = data.listTotal;
				var countPerPage = $scope.pageTotal;
				var currentNum = $scope.pageNum;
				var pageCount = total / countPerPage;
				var x = $scope.pageNum;
				
				var pagination = new Array();
				
				if(total%countPerPage != 0) {
					pageCount++;
				}
				
				x -= 1;
				while(x%10 != 0){
					x--;
				}
				x += 1;
				if(x <= 0){
					x = 1;
				}
				if(x > 10){
					//x-1
					$scope.prev = x-1;
					$scope.prevFlag = true;
					//pagination.push("prev");
					
				}else{
					$scope.prevFlag = false;
				}
				for(var num=1; num<= pageCount; num++) {
					if(x > pageCount){
						break;
					}
					if(num == 11){
						break;
					}
					if(x > total){
						break;
					}
					
					if(currentNum != x) {
						pagination.push(x);

					} else{
						pagination.push("("+x+")");
					}
					x++;
					
				}
				if((x-1)%10 == 0){
					if(total != 0  && x <= total){
						$scope.next = x;
						$scope.nextFlag = true;
					}else{
						$scope.nextFlag = false;
					}
				}else{
					$scope.nextFlag = false;
				}
				
				$scope.pagingObj = pagination;
			}else{
				
			}
		}).error(function(data,status,headers,config){
			console.log(status);
		});
	}
	
	
	
	/*$http({
		method: 'post',
		data: formData,
		url: '/admin/count/getList.do',
		headers: {'Content-Type':'application/json; charset=utf-8'}
	}).success(function(data,status,headers,config){
		if(data){
			$scope.list = data.beanlist;
		}else{
			
		}
	}).error(function(data,status,headers,config){
		console.log(status);
	});*/
	
	
}]);