var myApp = angular.module('main', []);



myApp.controller('mainCtrl', ['$scope' ,function ($scope) {
	var data = {};
	/*data.didView = true;
	$scope.$broadcast('viewPage', {data : data});*/
	$scope.subMenuGo = function(x){
		data.didView = false;
		data.fileView =false;
		$scope.$broadcast('viewPage', {data : data});
		if(x == 1){
			data.didView = true;
			
			$scope.$broadcast('viewPage', {data : data});
		}else if(x == 2){
			data.fileView = true;
			$scope.$broadcast('viewPage', {data : data});
		}
	}

}]);

myApp.controller('didCtrl', ['$scope','$http','$filter' ,function ($scope,$http,$filter) {
	
	
	$scope.view = true;
	$scope.pageTotal = 30;
	$scope.pageNum = 1;
	$scope.prev = 0;
	$scope.next = 0;
	$scope.changeMode = 1;
	$scope.now = new Date();
	$scope.dateString = $filter('date')($scope.now, "yyyy-MM-dd");
	$scope.dateString2 = $filter('date')($scope.now, "yyyy-MM-dd");
	$scope.g1_sort = true;
	$scope.g2_sort = true;
	
	getRegion();
	getList();
	
	$scope.$on('viewPage', function(event, args) {
		$scope.view = args.data.didView;
		if($scope.view == true){
			getRegion();
			getList();
        }	
    });
	
	
	
	
	
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
	
	$scope.getList = function(){
		$scope.pageNum = 1;
		getList();
	}
	
	
	
	
	function getRegion(){
		$scope.region_idx = '0';
		$scope.branch_idx = '0';
		$scope.didList_idx = '0';
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
		var formData = {
			"region_idx" : $scope.region_idx,
		};
		$http({
			method: 'post',
			data: formData,
			url: '/admin/count/getBranch.do',
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
		if($scope.branch_idx == '0'){
			return;
		}
		$scope.didList_idx = '0';
		var formData = {
			"branch_idx" : $scope.branch_idx,
		};
		$http({
			method: 'post',
			data: formData,
			url: '/admin/count/getDidList.do',
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.didList = data.beanlist;
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
			"region_idx" : $scope.region_idx,
			"branch_idx" : $scope.branch_idx,
			"didList_idx" : $scope.didList_idx,
			"g1_sort" : $scope.g1_sort,
			"g2_sort" : $scope.g2_sort,
			"dateString" : $scope.dateString,
			"dateString2" : $scope.dateString2,
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
	
	$scope.excelDown = function(){
		/*var prog;
		$.ajax({ 
			type: 'POST'
			, async: true
			, url: '/common/orderExcelAjax.do' 
			, data: $("#orderForm").serialize()
			, dataType : 'json'
			
			,beforeSend : function(){
				
			},
			
			success : function(data) {
				//alert(data.result);
			},
			error : function(error) {
				alert("error");
			}, complete: function() {
				reset();
				reSetting();
			}
		});*/
		
		var form = "<form action='/admin/count/didExcelDown.do' modelAttribute='didExcel' method='post'>"; 
		form += 
				"<input type='hidden'  name='region_idx' value='"+$scope.region_idx+"'></input>" +
				"<input type='hidden'  name='branch_idx' value='"+$scope.branch_idx+"'></input>" +
				"<input type='hidden'  name='didList_idx' value='"+$scope.didList_idx+"'></input>" +
				"<input type='hidden'  name='g1_sort' value='"+$scope.g1_sort+"'></input>" +
				"<input type='hidden'  name='g2_sort' value='"+$scope.g2_sort+"'></input>" +
				"<input type='hidden'  name='dateString' value='"+$scope.dateString+"'></input>" +
				"<input type='hidden'  name='dateString2' value='"+$scope.dateString2+"'></input>";
	 
		form += "</form>"; 
		jQuery(form).appendTo("body").submit().remove(); 
	}

	
}]);

myApp.controller('fileCtrl', ['$scope','$http','$filter', function ($scope,$http,$filter) {
	
	
	
	$scope.pageTotal = 30;
	$scope.pageNum = 1;
	$scope.prev = 0;
	$scope.next = 0;
	$scope.changeMode = 1;
	
	$scope.now = new Date();
	$scope.dateString = $filter('date')($scope.now, "yyyy-MM-dd");
	$scope.dateString2 = $filter('date')($scope.now, "yyyy-MM-dd");
	$scope.g1_sort = true;
	$scope.g2_sort = true;
	
	
	$scope.$on('viewPage', function(event, args) {
        $scope.view = args.data.fileView;
        if($scope.view == true){
        	getList();
        	getMedia();
        }
        
    });
	
	
	
	
	
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
	
	$scope.getList = function(){
		$scope.pageNum = 1;
		getList();
	}
	
	
	
	
	function getMedia(){
		$scope.media_idx = '0';
		var formData = {
		};
		$http({
			method: 'post',
			data: formData,
			url: '/admin/count/getMedia.do',
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.mediaList = data.beanlist;
			}else{
				
			}
		}).error(function(data,status,headers,config){
			console.log(status);
		});
		
		
	}
	
	function getList(){
		var formData = {
			"pageNum" : ($scope.pageNum-1)*$scope.pageTotal,
			"total" : $scope.pageTotal,
			"media_idx" : $scope.media_idx,
			"g1_sort" : $scope.g1_sort,
			"g2_sort" : $scope.g2_sort,
			"dateString" : $scope.dateString,
			"dateString2" : $scope.dateString2,
		};
		
		$http({
			method: 'post',
			data: formData,
			url: '/admin/count/getMediaList.do',
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
	
	$scope.excelDown = function(){

		var form = "<form action='/admin/count/mediaExcelDown.do' modelAttribute='mediaExcel' method='post'>"; 
		form += 
			"<input type='hidden'  name='media_idx' value='"+$scope.media_idx+"'></input>" +
			"<input type='hidden'  name='g1_sort' value='"+$scope.g1_sort+"'></input>" +
			"<input type='hidden'  name='g2_sort' value='"+$scope.g2_sort+"'></input>" +
			"<input type='hidden'  name='dateString' value='"+$scope.dateString+"'></input>" +
			"<input type='hidden'  name='dateString2' value='"+$scope.dateString2+"'></input>";
	 
		form += "</form>"; 
		jQuery(form).appendTo("body").submit().remove(); 
	}
}]);