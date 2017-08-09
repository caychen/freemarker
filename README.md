# freemarker

具体可以参考官网：[freemarker官网](http://freemarker.org/, "freemarker")

## 指令
* 简单的介绍了freemarker中常用的各种指令，如下：
    * ${} ${!}
    * if elseif else
    * assign
    * list
        * list的遍历
        * map的遍历
    * switch case break default
    * macro nested return
    * function return
<br/>
<br/>

## freemarker自定义函数
> 实现TemplateMethodModelEx接口，重写exec方法
>> 步骤：
* 新建一个method类，实现TemplateMethodModelEx接口，重写exec方法;<br/>
    * 需要注意的是exec的参数就是自定义函数传过来的参数,java中的数据类型尽量为freemarker的数据类型，比如：如果页面上是int数据，exec中要使用BigDecimal类型。<br/>
* 然后在controller层将自定义的函数名通过mv.addObject("自定义函数名",new 自定义函数类);<br/>
* 在页面上使用：自定义函数名(参数...)<br/>

## freemarker自定义指令
> 实现TemplateDirectiveModel接口，重写execute方法
>> 步骤：
* 新建一个directive类，实现TemplateDirectiveModel接口，重写execute方法，使用@Component或者@Service注解;
* 在freemarker的配置文件中配置freemarkerVariables;
* 在页面使用@作为自定义指令的前缀
    * 分号前面是入参，多个入参以空格分开，对应指令类execute方法中的params键值对；
	* 分号后面是出参，以逗号分开，对应指令类execute方法中的TemplateModel[]集合
    
## 内置函数：
* 字符串内置函数：
    * substring：截取
	* cap_first：首字母大写
	* ends_with：以...结束
	* contains：是否包含子串
	* date：把字符串转换为date类型
	* datetime：把字符串转换为datetime类型
	* time：把字符串转换为time类型
	* starts_with：以...开始
	* index_of：第一次出现的索引
	* last_index_of：最后一次出现的索引
	* split：分隔
	* trim：将首尾空格去掉
	
* 数值内置函数：
    * string：
    * ?string("0.##")：小数点后面保留N位
	* round：四舍五入
	* floor：下取整
	* ceiling：上取整
		
* List内置函数：
	* first：取第一个
	* last：取最后一个
	* seq_contains：序列是否包含
	* seq_index_of：首次出现的索引
	* size：长度
	* reverse：反转
	* sort：排序
	* sort_by：按照字段排序
	* chunk：分块。如chunk(4)表示的是每4个分为一组，是个集合,具体看笔记.txt
	
* is函数：
	* is_string：
	* is_number：
	* is_method：
	* has_content：同()一致
	* eval：求值
	
## 宏指令
> macro nested return

## 函数
> function return
