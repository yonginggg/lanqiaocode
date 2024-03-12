class node:
    def __init__(self, s, l=None, r=None):
        self.val = None
        self.l = l
        self.r = r
        if '0' in s and '1' in s:  self.val = 'F'
        elif '0' in s:             self.val = 'B'
        else:                      self.val = 'I'
        
def build(s):
    if len(s) == 1:   return node(s)
    if len(s) == 0:   return None
    root = node(s, build(s[:len(s)//2]), build(s[len(s)//2:]))
    return root

def postorder(root):
    if root:
        postorder(root.l)
        postorder(root.r)
        print(root.val, end='')
    else: return
    
n = int(input())
s = input()
root = build(s)
postorder(root)
