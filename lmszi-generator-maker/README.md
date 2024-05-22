# lms-generator-maker



:可以使用这个生成器制作工具来匹配替换项目中的指定字符串并且生成模板项目还有生成器的配置信息。



**工具的代码结构**：

![image-20240408172240232](https://service-edu-2000.oss-cn-hangzhou.aliyuncs.com/pic_go_areaimage-20240408172240232.png)





**具体使用**：

首先需要构建一个约定好的协议JSON

| 属性              | 说明               | 作用                                                         |
| ----------------- | ------------------ | ------------------------------------------------------------ |
| id                | 唯一标识           | 用来标识一个项目，对二次构建很重要，如果没填写会自动生成一个并返回 |
| meta              | meta是一个对象JSON | 配置这个项目的基本信息，如作者，说明基础包名                 |
| originProjectPath | 原始项目路径       | 用来指定需要模板化的项目                                     |
| fileConfig        | 文件配置           | 用来指定需要检索制作模板的文件范围                           |
| modelConfig       | 模型配置           | 设置生成器的选项，与文件配置关联                             |
| outputConfig      | 输出配置           | 是否从未分组文件中移除组内的同名文件                         |
|                   |                    |                                                              |



meta配置详细：

| 属性        | 说明       | 作用           |
| ----------- | ---------- | -------------- |
| author      | 作者       |                |
| basePackage | 基础包     | 生成器的基础包 |
| name        | 项目名字   |                |
| description | 项目的说明 |                |
|             |            |                |



fileConfig文件配置详细：

| 属性            | 说明           | 作用                                                         |
| --------------- | -------------- | ------------------------------------------------------------ |
| files           | 需要扫描的文件 | 具体参数：path(文件路径)，condition(条件,即是模型参数)       |
| fileGroupConfig | 文件分组配置   | 具体参数：condition(条件)，groupKey(组唯一标识)，groupName(组名) |
|                 |                |                                                              |

modelConfig模型配置详细：

| 属性             | 说明         | 作用                                                         |
| ---------------- | ------------ | ------------------------------------------------------------ |
| models           | 模型列表     | 具体惨呼：fieldName(属性名称)，type(类型)，description(说明)，defaultValue(默认值)，abbr(缩写)，replaceText(替换值) |
| modelGroupConfig | 模型分组配置 | 具体参数：condition(条件)，groupKey(组唯一标识)，groupName(组名)，type(类型)，description(说明) |
|                  |              |                                                              |



outputConfig输出配置详细：

| 属性                     | 说明                                 | 作用 |
| ------------------------ | ------------------------------------ | ---- |
| removeGroupFilesFromRoot | 是否从未分组文件中移除组内的同名文件 |      |
|                          |                                      |      |



使用例子：



```json
{
  "id": 1,
  "meta": {
    "author": "lms2000",
    "basePackage": "com.lms",
    "name": "springboot-init-generator",
    "description": "springboot初始化模板"
  },
 "originProjectPath": "E:\\lmszi\\lmszi_generator\\lmszi-generator-demo-projects\\springboot-init"
}
```



```json
{
  "id": 1,
  "fileConfig": {
    "fileGroupConfig": {
      "groupKey": "post",
      "groupName": "帖子文件组",
      "condition": "needPost"
    },
    "files": [
      {
        "path": "src/main",
        "filterConfigList":[
          {
            "range": "fileName",
            "rule": "contains",
            "value": "Post"
          }
        ]
      }
    ]
    },
  "modelConfig": {
    "models": [
      {
        "fieldName": "needPost",
        "type": "boolean",
        "description":"是否开启帖子功能",
        "defaultValue": true
      }
    ]
  }

}
```



```java
        
String rootPath = "examples/springboot-init";
        String configStr = ResourceUtil.readUtf8Str(rootPath + File.separator + "templateMaker233.json");
        TemplateMakerConfig templateMakerConfig = JSONUtil.toBean(configStr, TemplateMakerConfig.class);
        Meta meta= TemplateMaker.makeTemplate(templateMakerConfig);

        System.out.println(JSONUtil.toJsonStr(meta));
```

