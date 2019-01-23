
insert(D, nil, t(D,nil,nil)).
insert(D, t(X, L, R), t(A, B, C)) :- D < X, insert(D,L,N), (B,A,C) = (N,X,R).
insert(D, t(X, L, R), t(A, B, C)) :- D > X, insert(D,R,N), (B,A,C) = (L,X,N).

search(D, t(D,_,_)).
search(D, t(V,L,_)) :- D < V, search(D,L).
search(D, t(V,_,R)) :- D > V, search(D,R).

preorder(t(X,_,_),X).
preorder(t(_,L,_),X) :- preorder(L,X).
preorder(t(_,_,R),X) :- preorder(R,X).

inorder(t(_,L,_),X) :- inorder(L,X).
inorder(t(X,_,_),X).
inorder(t(_,_,R),X) :- inorder(R,X).

postorder(t(_,L,_),X) :- postorder(L,X).
postorder(t(_,_,R),X) :- postorder(R,X).
postorder(t(X,_,_),X).