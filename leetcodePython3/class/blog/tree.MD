### 二叉树类
    class TreeNode:
            val = 0
            left = None
            right = None
            def __init__(self, x):
                self.val = x
                self.left = None
                self.right = None
   ### 递归前序遍历
        def ergodicFont(self,root:TreeNode,li:list):
            if not  root:return
            li.append(root.val)
            self.ergodicFont(root.left,li)
            self.ergodicFont(root.right,li)
### 循环前序遍历
    def ergodicFont2(self, root: TreeNode, li: list):
        res = []
        while root or len(res):
            if root:#add的时候添加记录
                res.append(root)
                li.append(root.val)
                root = root.left
            else:
                root = res[-1]
                res.pop()
                root = root.right


   ### 递归中序遍历
    def ergodicMiddle(self, root: TreeNode, li: list):
        if not root: return
        self.ergodicMiddle(root.left, li)
        li.append(root.val)
        self.ergodicMiddle(root.right, li)
   ### 循环中序遍历
    def ergodicMiddle2(self, root: TreeNode, li: list):
        res = []
        while root or len(res):
            if root:
                res.append(root)
                root = root.left
            else:
                root = res[-1]#pop的时候添加记录
                li.append(root.val)
                res.pop()
                root = root.right


   ### 递归后序遍历
    def ergodicAfter(self, root: TreeNode, li: list):
        if not root: return
        self.ergodicAfter(root.left, li)
        self.ergodicAfter(root.right, li)
        li.append(root.val)
### 循环后序遍历
    def ergodicAfter2(self, root: TreeNode, li: list):
        res = []
        last  = set()
        while root or len(res):
            if root:
                res.append(root)
                root = root.left
            else:
                root = res[-1]  #
                while root:
                    if root.right is None:
                        li.append(root.val)
                        res.pop()
                        if len(res) == 0:
                            return
                        else:
                            root = res[-1]
                    else:
                        if last.__contains__(root):
                            li.append(root.val)
                            res.pop()
                            if len(res) == 0:return
                            else:
                                root = res[len(res)-1]
                        else:
                            last.add(root)
                            root = root.right
                            break

   ### 递归翻转二叉树
    def exchangeNode(self,root:TreeNode)->None:
        if not  root:return None
        if root.left is None and root.right is None:return None
        root.left ,root.right= root.right,root.left
        self.exchangeNode(root.right)
        self.exchangeNode(root.left)
### 循环翻转二叉树
    def exchangeNode2(self, root: TreeNode) -> None:
        if not root: return None
        if root.left is None and root.right is None: return None
        ahead = root
        li = [ahead]
        l,i=len(li),0
        while i < l:
            ahead = li[i]
            if ahead.left:
                li.append(ahead.left)
            if ahead.right:
                li.append(ahead.right)
            ahead.left, ahead.right = ahead.right, ahead.left
            l = len(li)
            i += 1
        self.printNode([],root)
    
