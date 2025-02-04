--create inpFunc
-- a = 1
-- b = 10
-- inpFunc = [a..b] 

a = 1
b = 5
inpFunc s
    | s == 's' = [a..b]
    | s == 'a' = [a..b] 
    | otherwise = error "wrong"

-- inpFunc = [a..b] 

--Define applicatorFunc
applicatorFunc inpFunc s = if s=='s' then sum inpFunc else (sum inpFunc) / fromIntegral (length inpFunc)  

main = do
    let result = applicatorFunc inpFunc 's' 
    putStrLn("sum = " ++ show(result))
