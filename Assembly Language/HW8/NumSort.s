/*This file is made by Hsin Han Wu*/
/*ID:403530026*/
	.section .text
	.global NumSort
	.type NumSort,%function
NumSort:
	mov ip, sp
	stmfd sp!,{fp, ip, lr, pc}
	sub fp, ip, #4
	
	/*r0 <= the size of array*/
	/*r1 <= the address of array*/
	
	/*do sorting*/
	/*Begin Function*/
	ldr r2, [r1],#4
	ldr r3, [r1],#4
	ldr r4, [r1]
	sub r1,r1,#8

	cmp r2, r3
	bgt .firstbig
	blt .firstsmall

.firstbig:
	cmp r2, r4
	bgt .thirdsmall1
	mov r5, r4
	mov r6, r2
	mov r7, r3
	b .last

.firstsmall:
	cmp r3, r4
	bgt .thirdsmall2
	mov r5, r4
	mov r6, r3
	mov r7, r2
	b .last

.thirdsmall1:
	cmp r3, r4
	bgt .abc
	mov r5, r2
	mov r6, r4
	mov r7, r3
	b .last

.thirdsmall2:
	cmp r2, r4
	bgt .bac
	mov r5, r3
	mov r6, r4
	mov r7, r2
	b .last

.abc:
	mov r5, r2
	mov r6, r3
	mov r7, r4
	b .last

.bac:
	mov r5, r3
	mov r6, r2
	mov r7, r4
	b .last
.last:
	/*Now store the results back*/
	str r7, [r1], #4
	str r6, [r1],#4
	str r5, [r1]
	sub r1,r1,#8
	mov r0,r1

	/*r0 <= the address of the result array*/
	ldmea fp, {fp, sp ,pc}

	/*assume result array can carry max 100 integers*/
	.section .data
	.type result,%object
	.size result, 400
result:
	.space 400
