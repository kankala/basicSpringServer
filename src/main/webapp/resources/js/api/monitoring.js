var myApp = angular.module('main', ['ngSanitize'])
.filter('errorMode', function () {
    return function (text) {
    	var result = '';
    	if(text == 1){
    		result = "<span class='errorMode1'>O</span>";
    	}else if(text == 2){
    		result = "<span class='errorMode2'>O<span>";
    	}else{
    		result = "<span class='errorMode0'>O<span>";
    	}
        return result;
    }
}).filter('localdate', function () {
	return function (dt) {
		return Date.utc.create('ko').set(dt).addYears(1900).format('{yyyy}-{MM}-{dd} / {tt} {12hr}:{mm}:{ss}');
	};
});


myApp.controller('mainCtrl', ['$scope' ,function ($scope) {
	

}]);

myApp.controller('monitoringCtrl', ['$scope','$http','$filter','$sce', function ($scope,$http,$filter,$sce) {
	$scope.view = true;
	$scope.pageTotal = 10;
	$scope.pageNum = 1;
	$scope.prev = 0;
	$scope.next = 0;
	$scope.changeMode = 1;
	$scope.now = new Date();
	$scope.dateString = $filter('date')($scope.now, "yyyy-MM-dd");
	$scope.dateString2 = $filter('date')($scope.now, "yyyy-MM-dd");
	
	getRegion();
	getDeviceNoresponse();
	
	
	
	
	
	$scope.listPrev = function(){
		$scope.pageNum = $scope.prev;
		
		getDeviceNoresponse();
	}
	$scope.listNext = function(){
		$scope.pageNum = $scope.next;
		getDeviceNoresponse();
	}
	$scope.listGo = function(x){
		if(x.toString().indexOf('(') == -1){
			$scope.pageNum = x;
			getDeviceNoresponse();
		}
	}
	
	$scope.getList = function(){
		$scope.pageNum = 1;
		getDeviceNoresponse();
	}
	
	
	$scope.regionClick = function(idx){
		$scope.region_idx = idx;
		getBranch();
		getDeviceNoresponse();
	}
	
	
	$scope.branchClick = function(idx){
		$scope.branch_idx = idx;
		getDidList();
		getDeviceNoresponse();
	}
	
	$scope.didListClick = function(idx){
		$scope.didList_idx = idx;
		getDevice();
		getDeviceNoresponse();
	}
	
	$scope.deviceClick = function(idx){
		$scope.device_idx = idx;
		getDeviceNoresponse();
		
	}
	
	
	function getRegion(){
		$scope.region_idx = '0';
		$scope.branch_idx = '0';
		$scope.didList_idx = '0';
		$scope.device_idx = '0';
		var formData = {
		};
		$http({
			method: 'post',
			data: formData,
			url: '/common/getRegion.do',
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.region = data.beanlist;
				
				getBranch();
			}else{
				
			}
		}).error(function(data,status,headers,config){
			console.log(status);
		});
		
		
	}
	
	
	
	$scope.getBranch = function(){
		getBranch();
	}
	
	function getBranch(){
		$scope.branch_idx = '0';
		$scope.didList_idx = '0';
		$scope.device_idx = '0';
		var formData = {
			"region_idx" : $scope.region_idx,
		};
		$http({
			method: 'post',
			data: formData,
			url: '/admin/monitoring/getBranch.do',
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.branch = data.beanlist;
				getDidList();
			}else{
				
			}
			
		}).error(function(data,status,headers,config){
			console.log(status);
		});
	}
	
	
	$scope.getDidList = function(){
		getDidList();
	}
	
	function getDidList(){
		if($scope.branch_idx == "0"){
			getDevice();
		}else{
			$scope.didList_idx = '0';
			$scope.device_idx = '0';
			var formData = {
				"region_idx" : $scope.region_idx,
				"branch_idx" : $scope.branch_idx,
			};
			$http({
				method: 'post',
				data: formData,
				url: '/admin/monitoring/getDidList.do',
				headers: {'Content-Type':'application/json; charset=utf-8'}
			}).success(function(data,status,headers,config){
				if(data){
					$scope.didList = data.beanlist;
					getDevice();
				}else{
					
				}
				
			}).error(function(data,status,headers,config){
				console.log(status);
			});
		}
	}
	
	
	$scope.getDevice = function(){
		getDevice();
	};
	
	function getDevice(){
		$scope.device_idx = '0';
		var formData = {
			"region_idx" : $scope.region_idx,
			"branch_idx" : $scope.branch_idx,
			"didList_idx" : $scope.didList_idx,
		};
		
		$http({
			method: 'post',
			data: formData,
			url: '/admin/monitoring/getDevice.do',
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.device = data.beanlist;
				
			}else{
				
			}
		}).error(function(data,status,headers,config){
			console.log(status);
		});
	}
	
	$scope.getDeviceNoresponse = function(){
		getDeviceNoresponse();
	};
	
	function getDeviceNoresponse(){
		rotation(true);
		var formData = {
			"pageNum" : ($scope.pageNum-1)*$scope.pageTotal,
			"total" : $scope.pageTotal,
			"region_idx" : $scope.region_idx,
			"branch_idx" : $scope.branch_idx,
			"didList_idx" : $scope.didList_idx,	
			"device_idx" : $scope.device_idx,
			"dateString" : $scope.dateString,
			"dateString2" : $scope.dateString2,
		};
		
		$http({
			method: 'post',
			data: formData,
			url: '/admin/monitoring/getDeviceNoresponse.do',
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.deviceNoresponse = data.beanlist;
				$scope.deviceNoresponseTotal = data.listTotal;
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
				rotation(false);
			}else{
				rotation(false);
			}
		}).error(function(data,status,headers,config){
			console.log(status);
		});
	}
	$scope.excelDown = function(){
		var form = "<form action='/admin/monitoring/excelDown.do' modelAttribute='excel' method='post'>"; 
		form += 
			"<input type='hidden'  name='region_idx' value='"+$scope.region_idx+"'></input>" +
			"<input type='hidden'  name='branch_idx' value='"+$scope.branch_idx+"'></input>" +
			"<input type='hidden'  name='didList_idx' value='"+$scope.didList_idx+"'></input>" +
			"<input type='hidden'  name='device_idx' value='"+$scope.device_idx+"'></input>" +
			"<input type='hidden'  name='dateString' value='"+$scope.dateString+"'></input>"+
			"<input type='hidden'  name='dateString2' value='"+$scope.dateString2+"'></input>";
		form += "</form>"; 
		jQuery(form).appendTo("body").submit().remove(); 
	}

	
}]);

