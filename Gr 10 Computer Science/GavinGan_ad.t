%1  Name: Gavin Gan Sept 13, 2010          /==============\
%2  Class: ISC2O0-06   Seat # 9            |    /    \    |
%3  Name of Program : Advertizement        |   /      \   |
%4  Description of Program:                |  /        \  |  |     / =========
%5  Gee Inc. Advertizement                 |    ______    |  |   /          /
%6                                         |    |    |    |  | /          /
%7                                         |    |    |    |  |          /
%8                                         ================  '        =========
%9 Bonus Coding
%10 Changing speed of text movement
%11 Inputting picture
%12 Music


setscreen ("graphics:800;600") %Setting Size Of Screen
View.Set ("offscreenonly") %Avoid Glitch
process playfile ()
    Music.PlayFile ("AdSong.mp3") %Locating Music
end playfile

var logo, line, shape, shape3, shape5, shape7 : int := 0 %Variation for movement speed
var shape2, shape4, shape6, shape8 : int := 600 %Movement form the end of screen
var pic1 := Pic.FileNew ("1.jpg") %inserting Pictures
var pic2 := Pic.FileNew ("2.jpg")
var pic3 := Pic.FileNew ("3.jpg")
var pic4 := Pic.FileNew ("4.jpg")
var pic := Pic.FileNew ("123816639625.jpg")
var font, font2, font3 : int %Front

fork playfile %Play Music

loop
    var x : array 1 .. 8 of int := init (25, 25, 125, 675, 775, 775, 675, 125) %Drawing Logo
    var y : array 1 .. 8 of int := init (360, 240, 140, 140, 240, 360, 460, 460)
    drawfillpolygon (x, y, 8, black)
    font := Font.New ("bold:54")
    font2 := Font.New ("bold :299")
    font3 := Font.New ("bold :80")

    drawfillarc (125, 240, 100, 100, 180, 270, black)
    drawfillarc (125, 360, 100, 100, 90, 180, black)
    drawfillarc (675, 240, 100, 100, 270, 0, black)
    drawfillarc (675, 360, 100, 100, 0, 90, black)

    var x2 : array 1 .. 8 of int := init (123, 55, 55, 123, 675, 745, 745, 675)
    var y2 : array 1 .. 8 of int := init (169, 250, 350, 431, 431, 350, 250, 169)
    drawfillpolygon (x2, y2, 8, white)

    drawfillarc (665, 351, 80, 80, 0, 90, white) %Drawing arc into Logo
    drawfillarc (665, 248, 80, 80, 270, 0, white)
    drawfillarc (134, 351, 80, 80, 90, 180, white)
    drawfillarc (134, 248, 80, 80, 180, 270, white)
    var G1 : array 1 .. 16 of int := init (80, 140, 140, 110, 110, 125, 125, 120, 120, 145, 145, 140, 140, 125, 125, 80)
    var G2 : array 1 .. 16 of int := init (400, 400, 370, 370, 330, 330, 340, 340, 355, 355, 340, 340, 300, 300, 315, 315)
    drawfillpolygon (G1, G2, 16, blue)
    var E1 : array 1 .. 12 of int := init (155, 220, 220, 172, 172, 220, 220, 172, 172, 220, 220, 155)
    var E11 : array 1 .. 12 of int := init (400, 400, 380, 380, 360, 360, 340, 340, 320, 320, 300, 300)
    drawfillpolygon (E1, E11, 12, 88)
    var E2 : array 1 .. 12 of int := init (230, 295, 295, 247, 247, 295, 295, 247, 247, 295, 295, 230)
    var E22 : array 1 .. 12 of int := init (400, 400, 380, 380, 360, 360, 340, 340, 320, 320, 300, 300)
    drawfillpolygon (E2, E22, 12, 88)
    drawoval (320, 390, 15, 15, black)
    drawarc (320, 390, 10, 10, 30, 330, black)
    Draw.Text ("ENTERTAINMENT", 110, 200, font, 28) %Drawing Letters
    if line > 1000
	    then
	drawfillstar (700, 500, 750, 450, blue)
	if line > 1350
		then

	    Draw.Cls %Clear Previous Drawing
	    drawoval (100, 400, 50, 50, black)
	    drawline (100, 350, 120, 250, black)
	    drawline (50, 300, 180, 300, black)
	    drawline (120, 250, 50, 150, black)
	    drawline (120, 250, 200, 150, black)
	    var x4 : array 1 .. 13 of int := init (164, 216, 212, 271, 265, 318, 311, 260, 261, 218, 218, 169, 164)
	    var y4 : array 1 .. 13 of int := init (272, 275, 322, 324, 275, 281, 226, 246, 178, 179, 247, 242, 273)
	    drawfillpolygon (x4, y4, 13, 02)
	    if line > 1950
		    then
		drawoval (100, 400, 50, 50, black)
		drawline (100, 350, 120, 250, black)
		drawline (50, 300, 180, 300, black)
		drawline (120, 250, 50, 150, black)
		drawline (120, 250, 200, 150, black)
		drawfillpolygon (x4, y4, 13, 02)
		var x5 : array 1..154 of int := init ( 345, 330, 331, 321, 311, 300, 302, 325, 350, 467, 488, 499, 490, 471, 462, 447, 441, 422, 407, 392, 378, 371, 380, 330, 381, 342, 342, 300, 389, 402, 303, 402, 434, 429, 388, 373, 364, 368, 379, 406, 431, 397, 386, 381, 427, 436, 447, 471, 488, 496, 490, 469, 462, 444, 435, 398, 404, 413, 426, 438, 442, 398, 408, 429, 445, 421, 407, 406, 414, 389, 381, 387, 428, 433, 411, 411,               436, 441, 426, 441, 437, 444, 470, 445, 440, 460, 439, 438, 469, 436, 464, 473, 487, 473, 469, 485, 468, 463, 481, 460, 435, 442, 427, 440, 434, 411, 412, 431, 303, 403, 389, 372, 365, 378, 373, 378, 364, 366, 378, 379, 367, 366, 378, 379, 368, 367, 364, 371, 388, 406, 305, 325, 348, 341, 347, 342, 307, 312, 342, 345, 317, 323, 345, 348, 332, 347, 466, 487, 500, 493, 490, 468, 461, 395)
		var y5 : array 1..154 of int := init ( 384, 378, 373, 364, 351, 326, 249, 217, 213, 236, 258, 339, 382, 388, 401, 401, 409, 411, 408, 393, 384, 391, 381, 377, 381, 331, 332, 327, 336, 286, 247, 286, 301, 344, 335, 342, 351, 363, 377, 388, 383, 372, 363, 358, 360, 371, 378, 377, 362, 356, 384, 388, 399, 401, 398, 399, 398, 405, 410, 402, 400, 399, 387, 382, 377, 373, 360, 359, 366, 366, 358, 336, 343, 304,                278, 250, 254, 265, 262, 265, 299, 252, 265, 254, 279, 289, 280, 297, 307, 297, 305, 266, 286, 268, 288, 303, 289, 304, 313, 304, 297, 263, 261, 265, 252, 251, 281, 300, 248, 287, 339, 334, 308, 310, 334, 309, 308, 302, 307, 295, 294, 303, 305, 297, 293, 303, 310, 336, 336, 287, 248, 218, 213, 265, 215, 259, 242, 233, 249, 240, 227, 219, 232, 222, 216, 215, 236, 258, 340, 363, 383, 389, 399, 397)
		drawpolygon (x5, y5, 157, 1)
	    end if
	    if line > 2500
		    then
		drawoval (100, 400, 50, 50, black)
		drawline (100, 350, 120, 250, black)
		drawline (50, 300, 180, 300, black)
		drawline (120, 250, 50, 150, black)
		drawline (120, 250, 200, 150, black)
		drawfillpolygon (x4, y4, 13, 02)
		drawfillbox (500, 400, 600, 350, black)
		drawfillbox (500, 300, 600, 250, black)
		var x5 : array 1..154 of int := init ( 345, 330, 331, 321, 311, 300, 302, 325, 350, 467, 488, 499, 490, 471, 462, 447, 441, 422, 407, 392, 378, 371, 380, 330, 381, 342, 342, 300, 389, 402, 303, 402, 434, 429, 388, 373, 364, 368, 379, 406, 431, 397, 386, 381, 427, 436, 447, 471, 488, 496, 490, 469, 462, 444, 435, 398, 404, 413, 426, 438, 442, 398, 408, 429, 445, 421, 407, 406, 414, 389, 381, 387, 428, 433, 411, 411, 436, 441, 426, 441, 437, 444, 470, 445, 440, 460, 439, 438, 469, 436, 464, 473, 487, 473, 469, 485, 468, 463, 481, 460, 435, 442, 427, 440, 434, 411, 412, 431, 303, 403, 389, 372, 365, 378, 373, 378, 364, 366, 378, 379, 367, 366, 378, 379, 368, 367, 364, 371, 388, 406, 305, 325, 348, 341, 347, 342, 307, 312, 342, 345, 317, 323, 345, 348, 332, 347, 466, 487, 500, 493, 490, 468, 461, 395)
		var y5 : array 1..154 of int := init ( 384, 378, 373, 364, 351, 326, 249, 217, 213, 236, 258, 339, 382, 388, 401, 401, 409, 411, 408, 393, 384, 391, 381, 377, 381, 331, 332, 327, 336, 286, 247, 286, 301, 344, 335, 342, 351, 363, 377, 388, 383, 372, 363, 358, 360, 371, 378, 377, 362, 356, 384, 388, 399, 401, 398, 399, 398, 405, 410, 402, 400, 399, 387, 382, 377, 373, 360, 359, 366, 366, 358, 336, 343, 304, 278, 250, 254, 265, 262, 265, 299, 252, 265, 254, 279, 289, 280, 297, 307, 297, 305, 266, 286, 268, 288, 303, 289, 304, 313, 304, 297, 263, 261, 265, 252, 251, 281, 300, 248, 287, 339, 334, 308, 310, 334, 309, 308, 302, 307, 295, 294, 303, 305, 297, 293, 303, 310, 336, 336, 287, 248, 218, 213, 265, 215, 259, 242, 233, 249, 240, 227, 219, 232, 222, 216, 215, 236, 258, 340, 363, 383, 389, 399, 397)
		drawpolygon (x5, y5, 155, 1)
		Draw.Text ("?", 600, 200, font2, red)
	    end if
	    if line > 3000
		    then
		Draw.Cls
		shape := shape + 10
		shape2 := shape2 - 10
		Draw.Text ("Whole New", shape, 200, font3, 30)
		Draw.Text ("World", shape2, 100, font3, 30)
		if shape > 100
			then
		    shape := shape - 9 %Speed Changing
		    shape2 := shape2 + 9
		    if shape > 300 then
			shape := shape + 10
			shape2 := shape2 - 10
			if line > 3800
				then
			    Draw.Cls

			    shape3 := shape3 + 7
			    shape4 := shape4 - 7
			    Draw.Text ("Wear Your", shape4, 450, font3, black)
			    Draw.Text ("Helmet", shape4, 300, font3, black)
			    Draw.Text ("Explore The", shape3, 150, font3, black)
			    Draw.Text ("Diffrent", shape3, 25, font3, black)
			    if line > 3850
				    then
				Pic.Draw (pic, 200, 150, picUnderMerge)
				if shape3 > 200
					then
				    shape3 := shape3 - 6
				    shape4 := shape4 + 6
				    if shape3 > 250
					    then
					shape3 := shape3 + 30
					shape4 := shape4 - 30
					if line > 4100
						then
					    Draw.Cls
					    Draw.Text ("Wear Your", shape4, 450, font3, black)
					    Draw.Text ("Helmet", shape4, 300, font3, black)
					    Draw.Text ("Explore The", shape3, 150, font3, black)
					    Draw.Text ("Dffrent", shape3, 25, font3, black)
					end if
					if line > 4150
						then
					    Draw.Cls
					    if line > 4155
						    then
						Pic.Draw (pic2, 0, 275, picMerge)
						if line > 4165
							then
						    Pic.Draw (pic1, 0, 0, picMerge)
						    if line > 4175
							    then
							Pic.Draw (pic3, 300, 275, picMerge)
							if line > 4185
								then
							    Pic.Draw (pic4, 0, 0, picMerge)
							    if line > 4195
								    then
								Draw.Cls
							    end if
							    if line > 4205
								    then
								Draw.Text ("Another Dimention", 0, 120, font, blue)
								Draw.Text ("Of Game Play", 0, 25, font3, blue)
								drawoval (150, 429, 60, 60, black)
								var x6 : array 1..41 of int := init (150, 150, 150, 197, 146,214, 194, 181, 178, 197, 195, 195, 196,221,211,205,221,235,240,222,239,234,294,297,255,223,228,279,230,237,220,207,212,211, 146, 149, 113, 149, 186, 151, 150)
								var y6 : array 1..41 of int := init (369, 211, 325, 274, 329, 302, 267, 267, 252, 251, 266, 267, 257, 301, 305, 315, 318, 309, 302, 300, 301, 309, 365, 406, 396, 316, 314, 383, 316, 306, 317, 315, 306, 304, 331, 211, 176, 212, 174, 213, 369)
								drawpolygon (x6, y6, 41, black)
								Draw.Text ("Another Dimention", 0, 120, font, blue)
								Draw.Text ("Of Game Play", 0, 25, font3, blue)
								if line > 4250
									then
								    Draw.Cls
								    drawoval (375, 490, 60, 60, black)
								    var x7 : array 1..39 of int := init (475, 335, 411, 411, 411, 334, 253, 337, 375, 360, 425, 359, 434, 361, 432, 422, 407, 419, 438, 431, 444, 456, 471, 449, 424, 416, 431, 448, 471, 450, 443, 495, 483, 433, 430, 431, 436, 469, 439)
								    var y7: array 1..39 of int := init (570, 320, 330, 231, 332, 320, 241, 323, 470, 410, 389, 410, 412, 411, 413, 376, 369, 355, 365, 375, 415, 415, 420, 437, 438, 429, 413, 415, 420, 437, 438, 527, 582, 547, 440, 439, 437, 544, 440)
								    drawpolygon (x7, y7, 39, black)
								    Draw.Text ("Of Game Play", 0, 25, font3, blue)
								    if line > 4300
									    then
									Draw.Cls
									drawoval (438, 490, 60, 60, black)
									Draw.Text ("Another Dimention", 0, 120, font, blue)
									Draw.Text ("Of Game Play", 0, 25, font3, blue)
									var x8 : array 1..144 of int := init (438, 417, 345, 417, 461, 467, 460, 418, 430, 467, 430, 488, 429, 489, 460, 446, 460, 472, 462, 468, 495, 484, 479, 497, 512, 515, 495, 487, 478, 497, 531, 581, 579, 507, 500, 555, 501, 507, 560, 575, 544, 540, 571, 539, 572, 544, 581, 575, 599, 610, 608, 688, 618, 725, 620, 706, 612, 671, 592, 630, 583, 587, 576, 581, 579, 570, 580, 562, 558, 574, 540, 539, 569, 540, 571, 564, 540, 527, 527, 544, 566, 575, 576, 584, 583, 603, 610, 610, 633, 646, 646, 643, 652, 672, 694, 668, 645, 627, 630, 647, 674, 646, 621, 600, 600, 595, 595, 581, 578, 577, 568, 564, 534, 535, 548, 556, 564, 563, 514, 494, 475, 493, 507, 523, 536, 519, 502, 481, 491, 500, 521, 528, 539, 561, 571, 543, 567, 542, 509, 495, 478, 490, 429, 438)
									var y8 : array 1..144 of int := init (430, 200, 142, 201, 203, 126, 203, 201, 283, 253, 285, 283, 288, 283, 245, 238, 227, 236, 248, 243, 278, 289, 298, 297, 284, 273, 278, 284, 299, 296, 385, 502, 360, 289, 295, 369, 296, 288, 340, 326, 326, 320, 315, 305, 307, 276, 303, 221, 298, 205, 302, 227, 310, 319, 324, 394, 341, 536, 344, 544, 343, 556, 501, 502, 361, 352, 335, 345, 341, 328, 325, 320, 315, 306, 307, 298, 290, 273, 256, 250, 247, 247, 226, 248, 245, 245, 211, 245, 250, 262, 267, 218, 192, 171, 172, 162, 178, 205, 164, 153, 147, 142, 145, 194, 204, 152, 128, 156, 197, 206, 143, 127, 126, 148, 136, 145, 195, 208, 149, 129, 169, 160, 166, 195, 211, 215, 179, 186, 203, 198, 255, 272, 291, 296, 306, 306, 315, 322, 288, 297, 298, 282, 286, 331)
									drawpolygon (x8, y8, 144, black)
								    end if
								end if
								if line > 4320
									then
								    Draw.Cls
								    shape5 := shape5 + 10
								    shape6 := shape6 - 10
								    Draw.Text ("Only With", shape5, 200, font3, red)
								    Draw.Text ("Gee's Digital", shape6, 100, font3, red)
								    Draw.Text ("Helmet", shape5, 25, font3, red)
								    var x5 : array 1..154 of int := init ( 345, 330, 331, 321, 311, 300, 302, 325, 350, 467, 488, 499, 490, 471, 462, 447, 441, 422, 407, 392, 378, 371, 380, 330, 381, 342, 342, 300, 389, 402, 303, 402, 434, 429, 388, 373, 364, 368, 379, 406, 431, 397, 386, 381, 427, 436, 447, 471, 488, 496, 490, 469, 462, 444, 435, 398, 404, 413, 426, 438, 442, 398, 408, 429, 445, 421, 407, 406, 414, 389, 381, 387, 428, 433, 411, 411, 436, 441, 426, 441, 437, 444, 470, 445, 440, 460, 439, 438, 469, 436, 464, 473, 487, 473, 469, 485, 468, 463, 481, 460, 435, 442, 427, 440, 434, 411, 412, 431, 303, 403, 389, 372, 365, 378, 373, 378, 364, 366, 378, 379, 367, 366, 378, 379, 368, 367, 364, 371, 388, 406, 305, 325, 348, 341, 347, 342, 307, 312, 342, 345, 317, 323, 345, 348, 332, 347, 466, 487, 500, 493, 490, 468, 461, 395)
								    var y5 : array 1..154 of int := init ( 384, 378, 373, 364, 351, 326, 249, 217, 213, 236, 258, 339, 382, 388, 401, 401, 409, 411, 408, 393, 384, 391, 381, 377, 381, 331, 332, 327, 336, 286, 247, 286, 301, 344, 335, 342, 351, 363, 377, 388, 383, 372, 363, 358, 360, 371, 378, 377, 362, 356, 384, 388, 399, 401, 398, 399, 398, 405, 410, 402, 400, 399, 387, 382, 377, 373, 360, 359, 366, 366, 358, 336, 343, 304, 278, 250, 254, 265, 262, 265, 299, 252, 265, 254, 279, 289, 280, 297, 307, 297, 305, 266, 286, 268, 288, 303, 289, 304, 313, 304, 297, 263, 261, 265, 252, 251, 281, 300, 248, 287, 339, 334, 308, 310, 334, 309, 308, 302, 307, 295, 294, 303, 305, 297, 293, 303, 310, 336, 336, 287, 248, 218, 213, 265, 215, 259, 242, 233, 249, 240, 227, 219, 232, 222, 216, 215, 236, 258, 340, 363, 383, 389, 399, 397)
								    drawpolygon (x5, y5, 157, 1)
								    if shape5 > 100 then
									shape5 := shape5 - 9
									shape6 := shape6 + 9
									if shape > 250 then
									    shape5 := shape5 + 10
									    shape6 := shape6 - 10
									    if line > 4400
										    then
										drawfillbox (0, 0, 800, 600, black)
									    end if
									end if
								    end if
								end if
							    end if
							end if
						    end if
						end if
					    end if
					end if
				    end if
				end if
			    end if
			end if
		    end if
		end if
	    end if
	end if
    end if
    exit when line > 4410
    logo := logo + 1
    line := line + 2
    drawline (line, 460, line - 300, 460, white)
    drawline (line, 140, line - 300, 140, white)
    View.Update
    delay (1)
    cls
    Draw.Arc (695, 55, 25, 40, 10, 350, black)         %initial
    Draw.Line (695, 48, 718, 48, black)
    Draw.Arc (760, 55, 25, 40, 10, 350, black)
    Draw.Line (760, 48, 785, 48, black)
end loop

