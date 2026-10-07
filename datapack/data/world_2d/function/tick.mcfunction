# Everyone lives on one line: z = 0.5, the middle of the row of blocks at z = 0.

# Players who just arrived: wait for the ground to load, then stand on it.
execute as @a[tag=w2d_fresh] at @s positioned over motion_blocking_no_leaves run tp @s ~ ~ ~
scoreboard players add @a[tag=w2d_fresh] w2d_age 1
tag @a[tag=w2d_fresh,scores={w2d_age=30..}] remove w2d_fresh

# Everybody else gets pulled back onto the line if they drift off it.
execute as @a[tag=!w2d_fresh] at @s unless predicate world_2d:on_line run tp @s ~ ~ 0.5
execute as @a at @s as @e[type=!minecraft:player,distance=..80] at @s unless predicate world_2d:on_line run tp @s ~ ~ 0.5

# Clear the blocks between the camera and the line a few times a second.
scoreboard players add #clear w2d_timer 1
execute if score #clear w2d_timer matches 4.. as @a[tag=!w2d_fresh] at @s run fill ~-14 ~-9 1 ~14 ~9 9 minecraft:air
execute if score #clear w2d_timer matches 4.. run scoreboard players set #clear w2d_timer 0
