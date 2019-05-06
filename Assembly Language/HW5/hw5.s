/*This file is made by Hsin Han Wu*/
/*ID:403530026*/
/* ========================= */
/*       DATA section        */
/* ========================= */
	.data
	.align 4

/* --- variable a --- */
	.type a, %object
	.size a, 24
a:
	.word 1 /*a11*/
	.word 2 /*a12*/
	.word 3 /*a13*/
	
	.word 4 /*a21*/
	.word 5 /*a22*/
	.word 6 /*a23*/

/* --- variable b --- */
	.type b, %object
	.size b, 24
b:
	.word 7 /*b11*/
	.word 8 /*b12*/

	.word 9 /*b21*/
	.word 10 /*b22*/

	.word 11 /*b31*/
	.word 12 /*b32*/

/* --- variable c --- */
	.type c, %object
	.size c, 16
c:
	.word 13
	.word 14
	.word 15
	.word 16

/* --- variable d --- */
	.type d, %object
	.size d, 16
d:
	.word 17
	.word 18
	.word 19
	.word 20


/* ========================= */
/*       TEXT section        */
/* ========================= */
	.section .text
	.global main
	.type main,%function
.matrix:
	.word a
	.word b
	.word c
	.word d
main:
	ldr r0, .matrix
	ldr r1, [r0], #4
	ldr r2, [r0], #4
	ldr r3, [r0]

	ldr r0, .matrix + 4
	ldr r4, [r0], #8
	ldr r5, [r0], #8
	ldr r6, [r0]

	mul r7, r1, r4
	mul r8, r2, r5
	add r4, r7, r8
	mul r10, r3, r6
	add r9, r4, r10

	ldr r0, .matrix + 4
	ldr r4, [r0, #4]
	ldr r5, [r0, #12]
	ldr r6, [r0, #20]
	
	mul r7, r1, r4
	mul r8, r2, r5
	add r1, r7, r8
	mul r11, r3, r6
	add r10, r1, r11

	ldr r0, .matrix
	ldr r1, [r0, #12]
	ldr r2, [r0, #16]
	ldr r3, [r0, #20]

	mul r7, r1, r4
	mul r8, r2, r5
	add r5, r7, r8
	mul r4, r3, r6
	add r12, r5, r4

	ldr r0, .matrix + 4
	ldr r4, [r0], #4
	ldr r5, [r0], #4
	ldr r6, [r0]

	mul r7, r1, r4
	mul r8, r2, r5
	add r4, r7, r8
	mul r1, r3, r6
	add r11, r4, r1
	
	/*End of A * B*/
	
	ldr r0, .matrix + 8
	ldr r1, [r0], #4
	ldr r2, [r0], #4
	ldr r3, [r0], #4
	ldr r4, [r0]

	add r5, r1, r9
	add r6, r2, r10
	add r7, r3, r11
	add r8, r4, r12

	ldr r0, .matrix +12
	ldr r1, [r0], #4
	ldr r2, [r0], #4
	ldr r3, [r0], #4
	ldr r4, [r0]
	
	ldr r0, .matrix +12
	str r5, [r0]
	str r6, [r0, #4]
	str r7, [r0, #8]
	str r8, [r0, #12]

	mov r1, r0

        nop


