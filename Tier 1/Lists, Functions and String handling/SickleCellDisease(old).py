def translate():
    dna = str(raw_input("Please enter a DNA string:"))
    dna_list = dna[0:3]
    if dna_list =="ATT" or dna_list == "ACT" or dna_list == "ATA":
        print "\nAmino Acid:", "Isoleucine"
        print "SLC:","I"
        print "DNA Condons:", "ATT, ATC, ATA"
    elif dna_list =="CTT" or dna_list == "CTC" or dna_list == "CTA" or dna_list == "CTG" or dna_list == "TTA" or dna_list == "TTG":
        print "\nAmino Acid:", "Leucine"
        print "SLC:","L"
        print "DNA Condons:", "CTT, CTC, CTA, CTG, TTA, TTG"
    elif dna_list =="GTT" or dna_list == "GTC" or dna_list == "GTA" or dna_list == "GTG":
        print "\nAmino Acid:", "Valine"
        print "SLC:","V"
        print "DNA Condons:", "GTT, GTC, GTA, GTG"
    elif dna_list =="TTT" or dna_list == "TTC":
        print "\nAmino Acid:", "Phenylalanine"
        print "SLC:","F"
        print "DNA Condons:", "TTT, TTC"
    elif dna_list =="ATG":
        print "\nAmino Acid:", "Methionine"
        print "SLC:","M"
        print "DNA Condons:", "ATG"

print translate()
