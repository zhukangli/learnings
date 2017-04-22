# 项目结构
test





# 开发流程
**功能开发**  
1. 新建分支：git checkout -b feature-x develop  
2. 开发完毕，合并到develop: 
    git checkout develop  
    git merge --no-ff feature-x   
3. 删除本地分支：git branch -d feature-x  

**简单说明**  
master是主干，保持跟线上代码一至；  
develop是新版本开发分支，必须从master开支出来，开发完毕测试通过后合并到master然后上线；  
hotfix-xxx分支是紧急bug修复分支，从master开出，修复完毕后合并到master和develop  

**功能开发**  
1. 新建分支：git checkout -b feature-x develop
2. 开发完毕，合并到develop: 
    git checkout develop  
    git merge --no-ff feature-x   
3. 删除本地分支：git branch -d feature-x  

**紧急bug修复**  
1. 从**master**分支checkout一条分支hotfix-xxx  
    git checkout master  
    git checkout -b hotfix-xxx master  
2. 开发完毕后提交代码和分支，提Merge Request（gitlab项目顶部菜单栏有个Merge Request），指派给康力合并代码到master主干  
    git commit -m "说明"  
    git push(如果是新分支，会提示push需要加额外参数，按提示做就行)  
3. 上线    
4. 把master分支更新到develop分支上保证develop分支代码最新  


# 项目更新

铂涛旅行商旅版更新时都会从预生产机器10.21.2.186相应的目录下去拉取更新源数据，如果某个应用需要更新，则把该应用需要更新的数据存放到该应用10.21.2.186的更新源目录里。
 
1、应用对应的更新源目录如下（10.21.2.186）：
#api和company存放于 /data/update_source/front目录下：
api更新源存放目录：  /data/update_source/front/api/
company更新源目录： /data/update_source/front/company/

#manage、agency和 charge存放于/data/update_source/admin目录下：
manage更新源目录： /data/update_source/admin/manage/   
 agency更新源目录： /data/update_source/admin/agency/   
 charge更新源目录： /data/update_source/admin/charge/   

2、更新操作如下（以更新api为例）：
 1）备份，更新前建议可以先备份，进入到 /data/update_source/ 目录
     cp  front/api   -R   ./backup/当前日期_api
      
 2）更新数据
    先进入到api更新源目录，然后删除以前的数据。

然后把需要更新的数据放入到目录里即可。
注: 存放的是已解压的数据文件，不是war包

   其它不需要更新的应用的目录则不需要动。
 

3、运维人员通过网页更新。
