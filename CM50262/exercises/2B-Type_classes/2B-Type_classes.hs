

ladies    = ["Mary","Kitty","Lydia","Elizabeth","Jane"]
gentlemen = ["Charles","Fitzwilliam","George","William"]
couples   = [("Elizabeth","Fitzwilliam"),("Charlotte","William"),("Lydia","George"),("Jane","Charles")]

------------------------- Exercise 1


ditch :: Int -> [a] -> [a]
-- ditch = undefined
ditch x [] = []
ditch 0 ys = ys
ditch x (y:ys) = ditch (x-1) ys

at :: [a] -> Int -> a
-- at = undefined
at [] i
  | i < 0 = error "negative index"
  | otherwise = error "index too large"
at (x:xs) 0 = x
at (x:xs) i = at xs (i-1)

------------------------- Exercise 2

find :: Eq a => a -> [(a,b)] -> b
-- find = undefined
find a [] = error "not found"
find a ((other_a,b):abs) 
  | other_a == a = b
  | otherwise = find a abs

which :: Eq a => a -> [a] -> Int
which = aux 0
  where
    aux :: Eq a => Int -> a -> [a] -> Int
    -- aux = undefined
    aux i v [] = error "not found"
    aux i v (x:xs) 
      | v == x = i
      | otherwise = aux (i+1) v xs

member :: Eq a => [a] -> a -> Bool
-- member    []  _ = undefined
-- member (x:xs) y
--     | x == y    = undefined
--     | otherwise = undefined
member    []  _ = False
member (x:xs) y
    | x == y    = True
    | otherwise = member xs y

remove :: Eq a => [a] -> a -> [a]
-- remove = undefined
remove [] y = []
remove (x:xs) y
    | x == y = remove xs y
    | otherwise = x : remove xs y

before :: Ord a => [a] -> [a] -> Bool
-- before _ [] = undefined
-- before [] _ = undefined
-- before (x:xs) (y:ys) = undefined
before _ [] = False
before [] _ = True
before (x:xs) (y:ys)
    | x > y = False
    | x == y = (xs == [] && ys /= []) || before xs ys
    | x < y = True

sorted :: Ord a => [a] -> Bool
-- sorted = undefined
-- sorted = undefined
sorted [] = True
sorted [x] = True
-- sorted (x:y:xs) = before x y && sorted (y:xs)
-- NOTE: can't use before because it expects a list
sorted (x:y:xs) = x < y && sorted (y:xs)


------------------------- Exercise 3

merge :: Ord a => [a] -> [a] -> [a]
-- merge xs [] = undefined
-- merge [] ys = undefined
-- merge (x:xs) (y:ys) = undefined
merge xs [] = xs
merge [] ys = ys
merge (x:xs) (y:ys)
  | x < y = x : merge xs (y:ys)
  | x > y = y : merge (x:xs) ys
  | otherwise = x : merge xs ys

minus :: Ord a => [a] -> [a] -> [a]
-- minus = undefined
minus xs [] = xs
minus [] ys = []
minus (x:xs) (y:ys)
  | x < y = x : minus xs (y:ys)
  | x > y = minus (x:xs) ys
  | x == y = minus xs ys

msort :: Ord a => [a] -> [a]
-- msort = undefined
msort [] = []
msort [x] = [x]

msort xs = merge (msort ys) (msort zs)
  --  using take, drop
  -- where
  --   idx = div (length xs) 2
  --   ys = take idx xs
  --   zs = drop idx xs 
  -- using splitAt
  -- where
  --   idx = div (length xs) 2
  --   (ys, zs) = splitAt idx xs
  -- without length, convoluted
  -- where 
  --   splitInHalf :: Ord a => [a] -> Bool -> [a] -> [a] -> ([a], [a])
  --   splitInHalf [] _ xxs yys = (xxs, yys)
  --   splitInHalf (x:xs) False xxs yys = splitInHalf xs True (x:xxs) yys
  --   splitInHalf (x:xs) True xxs yys = splitInHalf xs False xxs (x:yys)
  --   (ys, zs) = splitInHalf xs True [] []
  -- without length
  where 
    alternateSplit :: [a] -> ([a], [a])
    alternateSplit [] = ([], [])
    alternateSplit [x] = ([x], [])
    alternateSplit (x:y:xs) = (x:xs', y:ys')
      where 
        (xs', ys') = alternateSplit xs
    (ys, zs) = alternateSplit xs
