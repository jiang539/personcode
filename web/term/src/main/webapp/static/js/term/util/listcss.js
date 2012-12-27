jQuery.noConflict();
/**
 * 样式为table_tb的表格,鼠标经过的当前行背景色改变
 */
function tableCssTb() {
	jQuery(".table_list tr").mouseover(function() {
				// 如果鼠标移到class为table_tb的表格的tr上时，执行函数
				jQuery(this).addClass("over");
			}).mouseout(function() {
				// 给这行添加class值为over，并且当鼠标一出该行时执行函数
				jQuery(this).removeClass("over");
			}) // 移除该行的class
	//jQuery(".table_tb tr:even").addClass("alt");
	// 给class为stripe_tb的表格的偶数行添加class值为alt
}

jQuery(document).ready(function() {
			tableCssTb();
		});