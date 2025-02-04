ask prompt x = 
  do
  let new = prompt ++ replicate x '!' 
  putStrLn new 
  line <- getLine
  if line == ""
    then ask prompt (x + 1) 
    else if line == "quit"
      then putStrLn "quitting..."
      else putStrLn ("you said: '" ++ reverse line ++ "' in reverse") 

main = 
  do
  let prompt = "please say something"
  ask prompt 0 
