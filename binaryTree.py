class Node(object):
    def __init__(self, data):
        self.left = None
        self.right = None
        self.data = data

class BinaryTree(object):
    def __init__(self):
        self.root = None

    def insert(self, data, node):
        if self.root:
            if self.search(data, node) is not None:
                print('Duplicate dropped')
                return
            if data < node.data:
                if node.left is None:
                    node.left = Node(data)
                else:
                    self.insert(data, node.left)
            elif data > node.data:
                if node.right is None:
                    node.right = Node(data)
                else:
                    self.insert(data, node.right)
        else:
            self.root = Node(data)

    def search(self, data, node):
        if self.root:
            if not node:
                return None
            elif node.data == data:
                return node.data
            elif data < node.data:
                return self.search(data, node.left)
            else:
                return self.search(data, node.right)
        else:
            return None

    def preorder(self, node):
        if self.root is None:
            print('Tree is empty')
        print(node.data)
        if node.left:
            self.preorder(node.left)
        if node.right:
            self.preorder(node.right)


    def inorder(self, node):
        if self.root is None:
            print('Tree is empty')
        if node.left:
            self.inorder(node.left)
        print(node.data),
        if node.right:
            self.inorder(node.right)
    
    def postorder(self, node):
        if self.root is None:
            print('Tree is empty')
        if node.left:
            self.postorder(node.left)
        if node.right:
            self.postorder(node.right)
        print(node.data)

print('Instantiate Binary Tree\n')
t = BinaryTree()

print('Inserting: 5, 7, 3, 1, 4, 6, 8, 9')
t.insert(5, t.root)
t.insert(7, t.root)
t.insert(3, t.root)
t.insert(1, t.root)
t.insert(4, t.root)
t.insert(6, t.root)
t.insert(8, t.root)
t.insert(9, t.root)
print('\nInserting: 1')
t.insert(1, t.root)

print('\nSearching: 1,6,10')
print(t.search(1,t.root))
print(t.search(6,t.root))
print(t.search(10,t.root))

print('---------\nPostorder')
t.postorder(t.root)
print('---------\nPreorder')
t.preorder(t.root)
print('---------\nInorder')
t.inorder(t.root)