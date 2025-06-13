# Git的使用

 	

git init  新建仓库

工作区 暂存区 本地仓库

working directory  .git      

staging Area  .git/index

 local repo (git init的地方)    .git/objects



工作区  git add  到暂存区  git commit 到本地仓库





四种状态  未跟踪 未修改  已修改  已暂存

![image-20241017165209759](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241017165209759.png)

git status  

看状态  绿色是暂存区

(use "git rm --cached <file>..." to unstage)

通配符  同后缀的文件统一处理

  

.  同一目录 （一点）



![image-20241017172741789](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241017172741789.png)

mixed是默认参数





ls是工作区   ls-files是暂存区

不同分支



查找差异

git diff 默认工作区和暂存区 （已经ADD的话则无区别）

git diff HEAD 工作区和仓库的区别   没提交(commit)



git diff --cached 暂存区和版本库  没提交（但有ADD）的话和HEAD一样



commit后 无论head 还是cached 都没有区别

也能比较版本区别  

HEAD指向所在分支的最新节点

head~ 代表上一版本

HEAD~2  之前两个版本 以此类推

也能查文件名的区别

删文件也是删工作区 要更新  git add

git rm  工作区和暂存区也删了   记得要提交



.gitignore 

忽略掉文件

例如临时文件 中间文件 没啥用的东西 缓存







在 gitignore  里面加入 *.log  忽略掉所有



git -am 把git跟踪的文件提交到版本库

">>" 两个箭头表示追加到后面

已添加到版本库的文件   .gitignore没有作用

不删本地文件 而是删版本库  git rm --cached

git不会将空文件夹放入版本控制

status -s 简略版本

git commit -am 省略 git add

![image-20241018200417479](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241018200417479.png)

![image-20241018200453171](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241018200453171.png)

git pull  和git push

ssh的配置



vscode  （后期考虑其他IDE）

![image-20241018211837645](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241018211837645.png)

昨晚的是branch的学习 其实也没啥 


 
get333  444   666
