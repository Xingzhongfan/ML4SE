import os

def get_file_name():
    dir = "/Users/fanxingzhong/dotFiles"
    for files in os.walk(dir):
        for file in files:
            for name in file:
                if name[-3:] == 'dot':
                    os.system("dot -Tsvg "+name+" -o CFGoutput"+name+".svg")

def main():
    get_file_name()
main()