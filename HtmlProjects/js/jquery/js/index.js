$(document).ready(function() {
	// 存储图片索引
	var index = 0;
	// 定时切换
	setTimeout(slide(index), 2000);
	// 轮播
	function slide(index) {
		index++;
		if (index == 2) {
			index = 0;
		}
		// 计算距离
		var ml = index * (-520) + "px";
		$(".banner_ul").animate({
			"margin-left": ml
		}, 2000)
		$(".btn").eq(index).css("background-color", "black");
		$(".btn").not(index).css("background-color", "white");
	}
})
