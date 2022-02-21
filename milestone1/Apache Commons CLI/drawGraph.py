# This is the scipt to draw CFG and CG
import os

def drawCF():
    idx = 0
    create_idx = 0
    for line in open("commons-cli-master-CG"):
        if line[0] == "*" and create_idx == 0:
            file_write_obj = open("CGclass"+str(idx)+".dot",'w')
            file_write_obj.write("digraph {")
            file_write_obj.write('\n')
            create_idx += 1
            idx += 1
            continue
        elif line[0] == "*" and create_idx != 0:
            file_write_obj.write('\n')
            file_write_obj.write("}")
            file_write_obj = open("CGclass"+str(idx)+".dot",'w')
            file_write_obj.write("digraph {")
            file_write_obj.write('\n')
            create_idx += 1
            idx += 1
            continue
        if "->" not in line:
            continue
        file_write_obj.write(line)
        for i in range(idx):
            os.system("dot -Tsvg "+"CGclass"+str(i)+".dot"+" -o CGoutput"+str(i)+".svg")


def drawCFG():
    idx = 0
    create_idx = 0
    for line in open("commons-cli-master-CFG"):
        if line[0] == "*" and create_idx == 0:
            file_write_obj = open("CFGclass"+str(idx)+".dot",'w')
            file_write_obj.write("digraph {")
            file_write_obj.write('\n')
            create_idx += 1
            idx += 1
            continue
        elif line[0] == "*" and create_idx != 0:
            file_write_obj.write('\n')
            file_write_obj.write("}")
            file_write_obj = open("CFGclass"+str(idx)+".dot",'w')
            file_write_obj.write("digraph {")
            file_write_obj.write('\n')
            create_idx += 1
            idx += 1
            continue
        if "->" not in line:
            continue
        file_write_obj.write(line)
        for i in range(idx):
            os.system("dot -Tsvg "+"CFGclass"+str(i)+".dot"+" -o CFGoutput"+str(i)+".svg")

def main():
    drawCF()
    drawCFG()
main()
