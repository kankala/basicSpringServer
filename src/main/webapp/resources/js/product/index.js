var myApp = angular.module('main', [])
.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function(scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;
            
            element.bind('change', function(){
                scope.$apply(function(){
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}])

.filter("listLevel", function() {
	var result = "";
    return function(text) {
    	if(text == 2){
    		result = "관리자";
    	}else if(text == 3){
    		result = "유저";
    	}
        return result;
    }
});




myApp.controller('mainCtrl', ['$scope' ,function ($scope) {
	
	
	
	
}])
.filter('localdate', [function () {
	return function (dt) {
	  
    //return Date.utc.create('ko').set(dt).addYears(1900).format('{yyyy}-{MM}-{dd} / {tt} {12hr}:{mm}:{ss}');
		return Date.utc.create('ko').set(dt).format('{yyyy}-{MM}-{dd} / {tt} {12hr}:{mm}:{ss}');
  };
}])
.filter('trim', [function () {
    return function(value) {
    	
        /*if(!angular.isString(value)) {
            return value;
        }  
        return value.replace(/^\s+|\s+$/g, ''); // you could use .trim, but it's not going to work in IE<9*/ 
        return value.replace(/ /gi, '');
   };
}]);



myApp.controller('sub1Ctrl', ['$scope','$http','$q', function ($scope,$http,$q) {
	$scope.pageTotal = 10;
	$scope.pageNum = 1;
	$scope.prev = 0;
	$scope.next = 0;
	$scope.changeMode = 1;
	
	$scope.boardView = false;
	
	$scope.mfile3 = true;
	$scope.mfile2 = true;
	$scope.mfile1 = true;
	
	
	
	/*$scope.changeBoard = function(changeMode){
		if($scope.title == null){
			alert("제목를 입력해주세요");
			return;
		}
		if($scope.content == null){
			alert("내용를 입력해주세요");
			return;
		}
		$scope.changeMode = changeMode;
		
		if(changeMode == 1){
			var  check = confirm("등록하시겠습니까?");
			if(!check){
				return;
			}
			go();
		}else if(changeMode == 2){
			var  check = confirm("수정하시겠습니까?");
			if(!check){
				return;
			}
			go();
		}else if(changeMode == 3){
			var  check = confirm("삭제하시겠습니까?");
			if(!check){
				return;
			}
			go();
		}
		
		
		function go(){
			var formData = new FormData();
			
			formData.append('changeMode',$scope.changeMode);
			formData.append('idx',$scope.idx);
			formData.append('title',$scope.title);
			formData.append('content',$scope.content);

			formData.append('ifile1',$scope.ifile1);
			formData.append('ifile2',$scope.ifile2);
			formData.append('ifile3',$scope.ifile3);
			
			
			$http({
				method: 'post',
				url: '/admin/board/changeBoard.do',
				data: formData,
				headers: {'Content-Type':undefined},
				transformRequest: function(data, headersGetterFunction) {
	                return data;
				}
			}).success(function(data,status,headers,config){
				if(data){
					$scope.boardView = false;
				}else{	
				}d
				
				
				$scope.pageNum = 1;
				getBoardList();
			}).error(function(data,status,headers,config){
				console.log(status);
			});
		}
		
		
		
	};
	$scope.listPrev = function(){
		$scope.pageNum = $scope.prev;
		
		getBoardList();
	}
	$scope.listNext = function(){
		$scope.pageNum = $scope.next;
		getBoardList();
	}
	$scope.listGo = function(x){
		if(x.toString().indexOf('(') == -1){
			$scope.pageNum = x;
			getBoardList();
		}
	}
	
	$scope.getAdvertiserList = function(){
		$scope.pageNum = 1;
		getBoardList();
	}
	
	
	
	
	$scope.addButton = function(){
		$scope.boardView = true; 
		$scope.idx = 0;
		$scope.title = null;
		$scope.content = null;
		angular.element("input[type='file']").val(null);
		$scope.mfile3 = true;
		$scope.mfile2 = true;
		$scope.mfile1 = true;
		$scope.fileList = [];
	}
	
	$scope.boardSelect = function(obj){
		$scope.mfile3 = true;
		$scope.mfile2 = true;
		$scope.mfile1 = true;
		$scope.fileList = [];
		
		angular.element("input[type='file']").val(null);
		$scope.boardView = true;
		$scope.idx = obj.idx;
		$scope.title = obj.title;
		$scope.content = obj.content;
		//$scope.modifyBranchBtnShow = true;
		getFile(obj.idx);
	}
	
	$scope.fileDownload = function(obj){
		
		$('#downIdx').val(obj.idx);
		$('#downPath').val(obj.filePath);
		$('#downOriginalName').val(obj.originalName);
		$("#fileDownForm").submit();
		
	}*/
	
	$scope.getContentList = function(){
		getContentList();
	}
	
	getContentList();

	/*$scope.branchList = function(){
		getBranchList.reverse($scope,$http);
	} */
	
	/*$scope.deleteFile = function(obj){
		var formData = {
			"idx" : obj.idx,
			"originalName" : obj.originalName,
		};
		$http({
			method: 'post',
			url: '/admin/board/deleteFile.do',
			data: formData,
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				getFile(obj.b_idx);
			}else{	
			}
		}).error(function(data,status,headers,config){
			console.log(status);
		});
	}
	
	function getFile(idx){
		var formData = {
			"idx" : idx,
		};
		$http({
			method: 'post',
			url: '/admin/board/getFile.do',
			data: formData,
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.fileList = data.beanlist;
				var x = 1;
				angular.forEach(data.beanlist, function (obj) {
					if(x == 1){
						$scope.mfile3 = false;
					}else if(x == 2){
						$scope.mfile2 = false;
					}else if(x == 3){
						$scope.mfile1 = false;
					}
					x++;
		        });
				
				
			}else{	
			}
		}).error(function(data,status,headers,config){
			console.log(status);
		});
	}*/
	
	
	
	
	
	function getContentList(){
		$scope.idx = 0;
		$scope.title = "";
		$scope.content = "";
		
		var formData = {
			"pageNum" : ($scope.pageNum-1)*$scope.pageTotal,
			"total" : $scope.pageTotal,
			"title" : $scope.schTitle,
		};
		$http({
			method: 'POST',
			url: '/admin/product/productList.do',
			data: formData,
			headers: {'Content-Type':'application/json; charset=utf-8'}
		}).success(function(data,status,headers,config){
			if(data){
				$scope.schTitle = "";
				
				$scope.contentList =  data.beanlist;
				$scope.contentTotal = data.contentTotal;
				var total = data.contentTotal;
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
					if(total != 0  && x <= pageCount){
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
}]);

