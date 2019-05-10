'''
构建哈夫曼树

树的带权路径长度：为树中所有叶子结点的带权路径长度之和
'''

class Node(object):
    def __init__(self, name=None, value=None):
        self.name = name
        self.value = value
        self.left = None
        self.right = None

class HuffmanTree(object):
    # 以叶子节点为基础，反向建立Huffman树
    def __init__(self, char_weights):
        depth = 10  # 自己定义树的最大深度
        self.nodes = [Node(part[0], part[1]) for part in char_weights] #根据输入的字符以及出现的频率创建叶子节点
        while len(self.nodes) != 1:
            # 将所有node按照出现频率从大到小排序
            self.nodes.sort(key=lambda node:node.value, reverse=True)
            new_node = Node(value=(self.nodes[-1].value + self.nodes[-2].value))
            new_node.left = self.nodes.pop(-1)
            new_node.right = self.nodes.pop(-1)
            self.nodes.append(new_node)
        self.root = self.nodes[0]
        self.b = [0] * depth #用于保存每个叶子节点的Haffuman编码,range的值只需要不小于树的深度就行

    def encode(self):
        # 返回哈夫曼编码
        self.encode_map = {}
        def generate(tree, length):
            node = tree
            if not node:
                return
            elif node.name:
                temp_code = ''
                for i in range(length):
                    temp_code += str(self.b[i])
                self.encode_map[node.name]=temp_code
                return
            self.b [length] = 0
            generate(node.left, length+1)
            self.b[length] = 1
            generate(node.right, length+1)

        generate(self.root, 0)
        return self.encode_map



if __name__ == '__main__':
    char_weights = [('a',5),('b',4),('c',10),('d',8),('f',15),('g',2)]
    tree = HuffmanTree(char_weights)
    encode = tree.encode()
    print(encode)
