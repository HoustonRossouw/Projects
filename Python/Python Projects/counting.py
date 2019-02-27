google = "google.com"

ls = list(google)
sort_ls = sorted(set(ls))

for key in sort_ls:
    print key,":",google.count(key)
    


