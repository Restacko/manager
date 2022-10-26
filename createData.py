from datetime import datetime

text='INSERT INTO POST(id,title,content,created) VALUES\n'
n=100
for i in range(1,n):
    text = text + f"({i} ,'Test post {i}', 'Content {i}', '{datetime.now()}' ),\n"
text = text + f"({n} ,'Test post {n}', 'Content {n}', '{datetime.now()}' );\n"
text = text + 'INSERT INTO COMMENT(id,post_id,content,created) VALUES\n'
for i in range(1,n):
    post_id = 1 + i//10
    text = text + f"({i} ,'{post_id}', 'Content {i}', '{datetime.now()}' ),\n"
text = text + f"({n} ,'{1+n//10}', 'Content {n}', '{datetime.now()}');\n"

f = open("src/main/resources/data.sql", "w")
f.write(text)
f.close()