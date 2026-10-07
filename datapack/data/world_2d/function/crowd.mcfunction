# Run this with /function world_2d:crowd to fill the world with a bunch of players.
# They are mannequins: player-shaped stand-ins that stand still and show a name.

execute at @s positioned ~-10.5 ~ ~ run summon minecraft:mannequin ~ ~ ~ {CustomName:"Player 1",CustomNameVisible:1b,Tags:["w2d_crowd"]}
execute at @s positioned ~-7.5 ~ ~ run summon minecraft:mannequin ~ ~ ~ {CustomName:"Player 2",CustomNameVisible:1b,Tags:["w2d_crowd"]}
execute at @s positioned ~-4.5 ~ ~ run summon minecraft:mannequin ~ ~ ~ {CustomName:"Player 3",CustomNameVisible:1b,Tags:["w2d_crowd"]}
execute at @s positioned ~-1.5 ~ ~ run summon minecraft:mannequin ~ ~ ~ {CustomName:"Player 4",CustomNameVisible:1b,Tags:["w2d_crowd"]}
execute at @s positioned ~1.5 ~ ~ run summon minecraft:mannequin ~ ~ ~ {CustomName:"Player 5",CustomNameVisible:1b,Tags:["w2d_crowd"]}
execute at @s positioned ~4.5 ~ ~ run summon minecraft:mannequin ~ ~ ~ {CustomName:"Player 6",CustomNameVisible:1b,Tags:["w2d_crowd"]}
execute at @s positioned ~7.5 ~ ~ run summon minecraft:mannequin ~ ~ ~ {CustomName:"Player 7",CustomNameVisible:1b,Tags:["w2d_crowd"]}
execute at @s positioned ~10.5 ~ ~ run summon minecraft:mannequin ~ ~ ~ {CustomName:"Player 8",CustomNameVisible:1b,Tags:["w2d_crowd"]}
