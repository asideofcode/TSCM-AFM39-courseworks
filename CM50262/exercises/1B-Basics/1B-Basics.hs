

------------------------- Exercise 1

square :: Int -> Int
-- square x = undefined
square x = x * x

-- pythagoras a b c = undefined
pythagoras a b c = square a + square b == square c


------------------------- Exercise 2

factorial :: Int -> Int
-- factorial x
--     | x <= 1    = undefined
--     | otherwise = undefined

factorial x
    | x <= 1    = 1
    | otherwise = x * factorial(x-1)

euclid :: Int -> Int -> Int
-- euclid x y
--     | x == y = undefined
--     | x <  y = undefined
--     | x >  y = undefined

euclid x y
    | x <= 0 || y <= 0 = error "some arg is less than 0" 
    | x == y = x
    | x < y = euclid x y-x
    | x > y = euclid y x-y

power :: Int -> Int -> Int
-- power x y = undefined
--note: you will need to create your own cases,
--      replacing the equals (=) sign with guards
power x y
    | y < 0 = error "y cannot be less than 0"
    | y == 0 = 1
    | otherwise = x * power x (y-1)

------------------------- Exercise 3

range :: Int -> Int -> [Int]
-- range = undefined
--note: you will need to create your own guards
--      and add your own parameters
range x y
    | x > y = []
    | otherwise = x : range (x+1) y

times :: [Int] -> Int
-- times = undefined

--note: you will need to create your own pattern-matching
times [] = 1
times (x:xs) = x * times xs

fact :: Int -> Int
-- fact = undefined

fact x = times (range 1 x)