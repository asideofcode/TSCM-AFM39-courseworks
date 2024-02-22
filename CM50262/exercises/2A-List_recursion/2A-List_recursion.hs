

ladies    = ["Mary","Kitty","Lydia","Elizabeth","Jane"]
gentlemen = ["Charles","Fitzwilliam","George","William"]

------------------------- Exercise 1

member :: [String] -> String -> Bool
-- member    []  _ = undefined
-- member (x:xs) y
--     | x == y    = undefined
--     | otherwise = undefined
member    []  _ = False
member (x:xs) y
    | x == y    = True
    | otherwise = member xs y

member' :: [String] -> String -> Bool
-- member'    []  _ = undefined  
-- member' (x:xs) y = undefined
member'    []  _ = False  
member' (x:xs) y = x == y || member' xs y

remove :: [String] -> String -> [String]
-- remove = undefined
remove [] y = []
remove (x:xs) y
    | x == y = remove xs y
    | otherwise = x : remove xs y

------------------------- Exercise 2

members :: [String] -> [String] -> Bool
-- members xs    []  = undefined
-- members xs (y:ys) = undefined
members xs    []  = True
members xs (y:ys) 
    | member xs y = members xs ys
    | otherwise = False

members' :: [String] -> [String] -> Bool
-- members' = undefined
members' xs    []  = True
members' xs (y:ys) = member xs y && members' xs ys

removeAll :: [String] -> [String] -> [String]
-- removeAll = undefined
removeAll xs [] = xs
removeAll xs (y:ys) = removeAll (remove xs y) ys

------------------------- Exercise 3

before :: [Char] -> [Char] -> Bool
-- before _ [] = undefined
-- before [] _ = undefined
-- before (x:xs) (y:ys) = undefined
before _ [] = False
before [] _ = True
before (x:xs) (y:ys)
    | x > y = False
    | x == y = (xs == [] && ys /= []) || before xs ys
    | x < y = True

before' :: [Char] -> [Char] -> Bool
-- before' = undefined
before' _ [] = False
before' [] _ = True
before' (x:xs) (y:ys) = x < y || (x == y && before' xs ys)

sorted :: [String] -> Bool
-- sorted = undefined
sorted [] = True
sorted [x] = True
sorted (x:y:xs) = before' x y && sorted (y:xs)

