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

