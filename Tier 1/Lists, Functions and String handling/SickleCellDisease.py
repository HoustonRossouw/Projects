dna = str(raw_input("Please enter a DNA string:"))

def translate(dna):
    dna_list = []
    output_list = []
    while dna:
        dna_list.append(dna[:3])
        dna = dna[3:]
    for dna_if in dna_list:
        #print dna_if
        if dna_if == "ATT" or dna_if == "ACT" or dna_if == "ATA":
            output_list.append("I")
        elif dna_if =="CTT" or dna_if == "CTC" or dna_if == "CTA" or dna_if == "CTG" or dna_if == "TTA" or dna_if == "TTG":
            output_list.append("L")
        elif dna_if =="GTT" or dna_if == "GTC" or dna_if == "GTA" or dna_if == "GTG":
            output_list.append("V")
        elif dna_if =="TTT" or dna_if == "TTC":
            output_list.append("F")
        elif dna_if =="ATG":
            output_list.append("M")

    final_str = "".join(output_list)
    return final_str

def mutate():
    in_file = open("DNA.txt","r")
    out_normalDNA = open("normalDNA.txt","w")
    out_mutatedDNA = open("mutatedDNA.txt","w")
    text = in_file.read()
    out_normalDNA.write(text.replace("a","A"))
    out_mutatedDNA.write(text.replace("a","T"))
    in_file.close()
    out_normalDNA.close()
    out_mutatedDNA.close()
    
def txtTranslate(dna):
    normalDNA = open("normalDNA.txt","r")
    mutatedDNA = open("mutatedDNA.txt","r")
    dna1 = normalDNA.read()
    dna2 = mutatedDNA.read()
    print "\nnormalDNA Output:",translate(dna1),"\nmutatedDNA Output:",translate(dna2)
    normalDNA.close()
    mutatedDNA.close()
    
    
mutate()
print "Output:",translate(dna)
print txtTranslate(dna)# you will notice the "None" being printed, this is because we are not returning anything from txtTranslate() so we can't print it here, rather just call it on its own


